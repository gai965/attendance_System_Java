package com.example.demo.attendanceAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.attendanceAPI.data.Employees;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AttendanceApiRepository {
	private Employees[] employeesList;
	
	public Employees[] getEmployeesList() throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/employee";

		employeesList = setResponse(url);
		
		return employeesList;
	}
	
	public Employees[] setResponse(String url) throws JsonMappingException, JsonProcessingException {
		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		employeesList = mapper.readValue(json, Employees[].class);
		
		return employeesList;
	}
}