package com.example.demo.attendanceAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.attendanceAPI.data.Employees;
import com.example.demo.attendanceAPI.repository.EmployeeApiRepository;

@Service
public class EmployeeApiService {
	private final EmployeeApiRepository employeeApiRepository;

	public EmployeeApiService(EmployeeApiRepository employeeApiRepository) {
		this.employeeApiRepository = employeeApiRepository;
	}
	
	public List<Employees> getEmployeesList() throws IOException {
		Employees[] employeesList = employeeApiRepository.getEmployeesList();

		return Arrays.asList(employeesList);
	}
	
	public List<Employees> getEmployeeIndividual(int id) throws IOException {
		Employees[] employeeIndividual = employeeApiRepository.getEmployeeIndividualt(id);
		
		return Arrays.asList(employeeIndividual);
	}
}
