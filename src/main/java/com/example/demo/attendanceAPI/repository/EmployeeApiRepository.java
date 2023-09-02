package com.example.demo.attendanceAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.attendanceAPI.data.Employees;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class EmployeeApiRepository {
	
	public Employees[] getEmployeesList() throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/employee";

		Employees[] employeesList = returneEployeeInformation(url);
		
		return employeesList;
	}
	
	public Employees[] getEmployeeIndividualt(int id) throws IOException {
		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/employee?id=" + id;
		
		Employees[] employeeIndividual = returneEployeeInformation(url);
		
		return employeeIndividual;
	}
	
	public Employees[] returneEployeeInformation(String url) throws IOException {
		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Employees[] employeeInformation = mapper.readValue(json, Employees[].class);

		return employeeInformation;
	}
}
