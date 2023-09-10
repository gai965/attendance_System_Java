package com.example.demo.attendanceAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.attendanceAPI.data.Employees;
import com.example.demo.attendanceAPI.service.EmployeeApiService;

@Controller
public class EmployeeApiController {
	private final EmployeeApiService employeeApiService;

	public EmployeeApiController(EmployeeApiService employeeApiService) {
		this.employeeApiService = employeeApiService;
	}

	@GetMapping("employeeslist")
	public String employeeListDisplay(Model model) throws IOException {
		List<Employees> employeesList = employeeApiService.getEmployeesList();

		model.addAttribute("employeesList", employeesList);

		return "employeeslist";
	}
}
