package com.stc.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stc.employee.model.Department;

@Service
public class DepartmentService {
	@Autowired
	RestTemplate restTemplate;

	public Department getDepartmentByDepartmentId(long departmentId) {
		return restTemplate.getForObject("http://department-service/departments/" + departmentId, Department.class);
	}
}
