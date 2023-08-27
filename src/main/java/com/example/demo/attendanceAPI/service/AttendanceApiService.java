package com.example.demo.attendanceAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.attendanceAPI.data.Employees;
import com.example.demo.attendanceAPI.data.Clocks;
import com.example.demo.attendanceAPI.repository.AttendanceApiRepository;

@Service
public class AttendanceApiService {
	private final AttendanceApiRepository attendanceApiRepository;

	public AttendanceApiService(AttendanceApiRepository attendanceApiRepository) {
		this.attendanceApiRepository = attendanceApiRepository;
	}

	public List<Employees> getEmployeesList() throws IOException {
		Employees[] employeesList = attendanceApiRepository.getEmployeesList();

		return Arrays.asList(employeesList);
	}
	
	public List<Clocks> getEmployeeDetail(int id) throws IOException {
		Clocks[] employeeDetail = attendanceApiRepository.getEmployeesemployeeDetail(id);

		return Arrays.asList(employeeDetail);
	}
}
