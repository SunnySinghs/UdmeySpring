package com.sourabh.springdemo.service;

import java.util.List;

import com.sourabh.springdemo.entity.Customer;

public interface StudentService {

	public  List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String customerName);
}
