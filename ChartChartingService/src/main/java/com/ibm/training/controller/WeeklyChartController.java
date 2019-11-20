package com.ibm.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.model.EmployeeGrowth;
import com.ibm.training.service.WeeklyChartService;




@CrossOrigin(origins = "http://localhost:*")
@RestController
public class WeeklyChartController {
	
	@Autowired
	WeeklyChartService service;
	
	@RequestMapping("/employees")
	Iterable<EmployeeGrowth> getAllEmployees()
	{
		return service.getAllEmployees();
	}
	
	@RequestMapping("/employees/lastmonth/{month}")
	Iterable<EmployeeGrowth> getAllEmployeesForLastMonth(@PathVariable Integer month)
	{
		return service.getAllEmployeesForLastMonth(month);
	}
	
	@RequestMapping("/employees/{month}")
	Iterable<EmployeeGrowth> getAllEmployeesByMonth(@PathVariable Integer month)
	{
		return service.getAllEmployeesByMonth(month);
	}

}