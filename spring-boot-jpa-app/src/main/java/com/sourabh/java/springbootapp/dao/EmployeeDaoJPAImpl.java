package com.sourabh.java.springbootapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sourabh.java.springbootapp.entity.Employee;

@Repository
public class EmployeeDaoJPAImpl implements EmployeeDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee theEmployee = entityManager.merge(employee);
		employee.setId(theEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
