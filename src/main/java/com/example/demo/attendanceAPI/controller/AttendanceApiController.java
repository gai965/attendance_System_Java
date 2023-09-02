package com.example.demo.attendanceAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.attendanceAPI.data.Employees;
import com.example.demo.attendanceAPI.data.Clocks;
import com.example.demo.attendanceAPI.service.AttendanceApiService;
import com.example.demo.attendanceAPI.service.EmployeeApiService;

@Controller
public class AttendanceApiController {
	private final AttendanceApiService attendanceApiService;
	private final EmployeeApiService employeeApiService;

	public AttendanceApiController(AttendanceApiService attendanceApiService, EmployeeApiService employeeApiService) {
		this.attendanceApiService = attendanceApiService;
		this.employeeApiService = employeeApiService;
	}

	@GetMapping("employeeslist")
	public String employeeListDisplay(Model model) throws IOException {
		List<Employees> employeesList = employeeApiService.getEmployeesList();

		model.addAttribute("employeesList", employeesList);

		return "employeeslist";
	}

	@GetMapping("employeeattendance")
	public String employeeAttendanceDisplay(@RequestParam("employeeid") int employeeid, Model model)
			throws IOException {

		List<Clocks> employeeAttendance = attendanceApiService.getEmployeeAttendance(employeeid);
		List<Employees> employeeIndividual = employeeApiService.getEmployeeIndividual(employeeid);

		model.addAttribute("employeeAttendance", employeeAttendance);
		model.addAttribute("employeeIndividual", employeeIndividual);

		return "employeeattendance";
	}

}
