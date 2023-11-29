package com.raghu.repo.service;

import java.util.List;

import com.raghu.model.Employee;

public interface IEmployeeService {
	
	public Employee createEmployee(Employee employee);
	public Employee updateEmployee(Integer empId,Employee employee);
	public void deleteEmployee(Integer empId);
	public Employee getOneEmployee(Integer empId);
	public List<Employee> getAllEmployees();
}
