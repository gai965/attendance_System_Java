package com.example.demo.attendanceAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.attendanceAPI.data.Clocks;
import com.example.demo.attendanceAPI.repository.AttendanceApiRepository;

@Service
public class AttendanceApiService {
	private final AttendanceApiRepository attendanceApiRepository;

	public AttendanceApiService(AttendanceApiRepository attendanceApiRepository) {
		this.attendanceApiRepository = attendanceApiRepository;
	}
	
	public List<Clocks> getEmployeeAttendance(int id) throws IOException {
		Clocks[] employeeAttendance = attendanceApiRepository.getEmployeeAttendance(id);

		return Arrays.asList(employeeAttendance);
	}
}
