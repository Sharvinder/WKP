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
	
	@RequestMapping("/employees/lastmonth/{month}/{year}/{project_name}")
	Iterable<EmployeeGrowth> getAllEmployeesForLastMonth(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name)
	{
		return service.getAllEmployeesForLastMonth(month, year, project_name);
	}
	
	@RequestMapping("/employees/{month}/{year}/{project_name}")
	Iterable<EmployeeGrowth> getAllEmployeesByMonth(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name)
	{
		return service.getAllEmployeesByMonth(month, year, project_name);
	}

}
