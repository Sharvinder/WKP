package com.ibm.training.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.training.model.EmployeeGrowth;



@Repository
public interface MonthlyChartRepository extends CrudRepository<EmployeeGrowth, Integer>{

	@Query(value = "select * from employee_growth where month=:month" ,nativeQuery = true)
	Iterable<EmployeeGrowth> findByMonth(@Param(value = "month")Integer month);

	@Query(value = "select * from employee_growth where month<:month", nativeQuery = true)
	Iterable<EmployeeGrowth> findAllMonthsBeforeCurrent(@Param(value = "month")Integer month);

}
