package com.stc.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stc.employee.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
public List<Employee> findByDepartmentId(Long departmentId);
}
