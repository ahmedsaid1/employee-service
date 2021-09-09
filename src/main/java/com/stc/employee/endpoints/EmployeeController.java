package com.stc.employee.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stc.employee.model.Employee;
import com.stc.employee.model.ResponseTemplate;
import com.stc.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		log.info("saveEmployee method in EmployeeController");
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("all/{deptId}")
	public List<Employee> getEmployeesByDepartment(@PathVariable long deptId){
		log.info("get EmployeesByDepartment method in EmployeeController");

		return employeeService.getEmployeesByDepartment(deptId);
	}
	@GetMapping("/{userId}")
	public ResponseTemplate getEmployeeWithDepartment(@PathVariable Long userId) {
		log.info("getEmployeeWithDepartment method in EmployeeController");

		return employeeService.getEmployeeWithDepartment(userId);
	}
	
	
}
