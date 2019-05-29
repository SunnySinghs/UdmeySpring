package com.sourabh.java.springbootapp.dao;

import java.util.List;

import com.sourabh.java.springbootapp.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
