package com.stc.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.employee.exception.DepartmentNotExistExciption;
import com.stc.employee.model.Department;
import com.stc.employee.model.Employee;
import com.stc.employee.model.ResponseTemplate;
import com.stc.employee.repository.EmployeeRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	DepartmentService departmentService;

	public Employee saveEmployee(Employee employee) {
		log.info("saveEmployee method in EmployeeService");
		Department department = departmentService.getDepartmentByDepartmentId(employee.getDepartmentId());
		if (department == null)
			throw new DepartmentNotExistExciption("not found department with this departmentId");
		return employeeRepo.save(employee);
	}

	public ResponseTemplate getEmployeeWithDepartment(Long userId) {
		ResponseTemplate responseTemplate = new ResponseTemplate();
		Employee employee = employeeRepo.findById(userId).get();
		Department department = departmentService.getDepartmentByDepartmentId(employee.getDepartmentId());
		responseTemplate.setEmployee(employee);
		responseTemplate.setDepartment(department);
		return responseTemplate;
	}

	public List<Employee> getEmployeesByDepartment(long deptId) {
		log.info("getEmployeesByDepartment method in EmployeeService");
		return employeeRepo.findByDepartmentId(deptId);
	}
	

}
