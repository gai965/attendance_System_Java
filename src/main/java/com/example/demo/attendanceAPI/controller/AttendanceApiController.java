package com.example.demo.attendanceAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("employeeattendance")
	public String employeeAttendanceDisplay(@RequestParam("employeeid") int employeeId, Model model)
			throws IOException {

		List<Clocks> employeeAttendance = attendanceApiService.getEmployeeAttendance(employeeId);
		List<Employees> employeeIndividual = employeeApiService.getEmployeeIndividual(employeeId);

		model.addAttribute("employeeAttendance", employeeAttendance);
		model.addAttribute("employeeIndividual", employeeIndividual);

		return "employeeattendance";
	}

	@PostMapping("attendanceregister")
	public String attendanceRegister(@RequestParam("employeeid") int employeeId,
			@RequestParam("type") String type, Model model) throws IOException {
		
		attendanceApiService.registerAttendance(employeeId, type);

		List<Clocks> employeeAttendance = attendanceApiService.getEmployeeAttendance(employeeId);
		List<Employees> employeeIndividual = employeeApiService.getEmployeeIndividual(employeeId);

		model.addAttribute("employeeAttendance", employeeAttendance);
		model.addAttribute("employeeIndividual", employeeIndividual);

		return "employeeattendance";
	}

}
