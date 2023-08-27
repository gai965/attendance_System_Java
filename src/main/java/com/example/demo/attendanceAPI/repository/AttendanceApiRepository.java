package com.example.demo.attendanceAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.attendanceAPI.data.Clocks;
import com.example.demo.attendanceAPI.data.Employees;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AttendanceApiRepository {
	
	public Employees[] getEmployeesList() throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/employee";
		
		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Employees[] employeesList = mapper.readValue(json, Employees[].class);
		
		return employeesList;
	}
	
	public Clocks[] getEmployeesemployeeDetail(int id) throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/clock?employeeId=" + id;
		
		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Clocks[] employeeDetail = mapper.readValue(json, Clocks[].class);
		
		return employeeDetail;
	}
}