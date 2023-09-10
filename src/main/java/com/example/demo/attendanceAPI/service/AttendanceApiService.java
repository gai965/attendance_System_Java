package com.example.demo.attendanceAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.demo.attendanceAPI.data.Clocks;
import com.example.demo.attendanceAPI.repository.AttendanceApiRepository;

@Service
public class AttendanceApiService {
	private final AttendanceApiRepository attendanceApiRepository;

	public AttendanceApiService(AttendanceApiRepository attendanceApiRepository) {
		this.attendanceApiRepository = attendanceApiRepository;
	}

	public List<Clocks> getEmployeeAttendance(int employeeId) throws IOException {
		Clocks[] employeeAttendance = attendanceApiRepository.getEmployeeAttendance(employeeId);

		return Arrays.asList(employeeAttendance);
	}

	public void registerAttendance(int employeeId, String type) throws IOException {
		// 現在時刻取得
		LocalDateTime localDateTime = LocalDateTime.now();
		// 取得した時間の表示変換
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fdate = dtformat.format(localDateTime);

		// 社員番号(employeeId)とクリックしたボタン(type)と表示変換した時間(fdate)を関数の引数にする
		attendanceApiRepository.registerAttendance(employeeId, type, fdate);
	}
}
