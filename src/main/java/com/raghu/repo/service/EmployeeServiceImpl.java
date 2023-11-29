package com.raghu.repo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.raghu.model.Employee;
import com.raghu.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	

	@Override
	@CacheEvict(value = "employees", allEntries = true)
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	@CacheEvict(value = "employees", allEntries = true)
	public Employee updateEmployee(Integer empId, Employee employee) {
		Employee emp= repository.findById(empId).get();
		emp.setEmpName(employee.getEmpName());
		emp.setEmpSal(employee.getEmpSal());
		repository.save(emp);
		return emp;
	}

	@Override
	@CacheEvict(value = "employees", allEntries = true)
	public void deleteEmployee(Integer empId) {
		Employee emp= repository.findById(empId).get();
		repository.delete(emp);
		
	}

	@Transactional
	@Cacheable(value = "employees",key = "#empId")
	@Override
	public Employee getOneEmployee(Integer empId) {
		return repository.findById(empId).get();
	}

	@Transactional
	@Cacheable(value = "employees",key = "#empId")
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

}
