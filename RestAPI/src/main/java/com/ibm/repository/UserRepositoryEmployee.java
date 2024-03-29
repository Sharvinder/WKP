package com.ibm.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bean.EmployeeDetails;

@Repository
public interface UserRepositoryEmployee extends CrudRepository<EmployeeDetails, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update employee_details set email=:email, designation=:designation, phone_number=:phoneNumber"
			+ ", technologies=:technologies where full_name=:employeeName",nativeQuery = true)
	void updateEmployeeByName(@Param(value = "email")String email,@Param(value = "designation") String designation,
			@Param(value = "phoneNumber")String phoneNumber,@Param(value = "technologies") String technologies,
			@Param(value = "employeeName")String employeeName);
	
	@Modifying
	@Transactional
	@Query(value = "delete from employee_details where full_name = :employeeName",nativeQuery = true)
	void deleteByName(@Param (value = "employeeName")String employeeName);

	@Modifying
	@Transactional
	@Query(value = "update employee_details set availability='NO', project_assigned=:projectName"
			+ " where full_name=:empName",nativeQuery = true)
	void assignProject(@Param(value = "empName")String empName, @Param(value = "projectName")String projectName);

	@Query(value = "select * from employee_details where availability='YES'",nativeQuery = true)
	Iterable<EmployeeDetails> getAvailableEmployees();
	
	@Query(value = "select * from employee_details where project_assigned=:projectName",nativeQuery = true)
	Iterable<EmployeeDetails> findAllEmployeesInProject(@Param(value = "projectName")String projectName);

	
	@Modifying
	@Transactional
	@Query(value = "update employee_details set availability='YES', project_assigned='Not assigned'"
			+ " where full_name=:empName",nativeQuery = true)
	void setDefault(@Param(value = "empName")String empName);

	@Modifying
	@Transactional
	@Query(value = "update employee_details set availability='YES', project_assigned='Not assigned'" + 
			" where project_assigned=:projectName",nativeQuery = true)
	void resetEmployeeWithDeleteProject(@Param(value = "projectName")String projectName);
	
	@Query(value = "select * from employee_details where emp_id=:empId",nativeQuery = true)
	Iterable<EmployeeDetails> findFullNameByEmpId(@Param(value = "empId")int empId);
}
