package com.raghu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.model.Employee;
import com.raghu.repo.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping("/one/{empId}")
	public Employee getOneEmployee(@PathVariable(value="empId") Integer empId) {
		return employeeService.getOneEmployee(empId);
	}

	@PutMapping("/mofify/{empId}")
	public Employee updateEmployee(@PathVariable(value="empId") Integer empId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(empId, employee);
	}
	
	@DeleteMapping("/remove/{empId}")
	public void deleteEmp(@PathVariable(value="empId") Integer empId) {
		employeeService.deleteEmployee(empId);
	}
}
