package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.model.EmployeeGrowth;
import com.ibm.training.repository.MonthlyChartRepository;

@Service
public class WeeklyChartService {
	
	@Autowired
	MonthlyChartRepository repo;

	public Iterable<EmployeeGrowth> getAllEmployees() {
		
		return repo.findAll();
	}

	public Iterable<EmployeeGrowth> getAllEmployeesForLastMonth(Integer month) {
		return repo.findByMonth(month);
	}

	public Iterable<EmployeeGrowth> getAllEmployeesByMonth(Integer month) {
		return repo.findAllMonthsBeforeCurrent(month);
	}

}