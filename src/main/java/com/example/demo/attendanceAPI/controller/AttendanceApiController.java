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

@Controller
public class AttendanceApiController {
	private final AttendanceApiService attendanceApiService;

	public AttendanceApiController(AttendanceApiService attendanceApiService) {
		this.attendanceApiService = attendanceApiService;
	}

	@GetMapping("employeeslist")
	public String employeeListDisplay(Model model) throws IOException {
		List<Employees> employeesList = attendanceApiService.getEmployeesList();

		model.addAttribute("employeesList", employeesList);

		return "employeeslist";
	}

	@GetMapping("employeedetail")
	public String employeeDetailDisplay(@RequestParam("employeeid") int employeeid,
			@RequestParam("employeename") String employeename, Model model) throws IOException {
		List<Clocks> employeeDetail = attendanceApiService.getEmployeeDetail(employeeid);
				
		model.addAttribute("employeeDetail", employeeDetail);
		return "employeedetail";
	}

}
