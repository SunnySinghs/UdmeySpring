package com.sourabh.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sourabh.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createQuery("from Customer order by lastName", Customer.class).getResultList();
		return customers;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCutomer(String customerName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if(customerName!=null) {
			query = session.createQuery("from Customer where"
					+ " lower(firstName) like:theName or lower(lastName) like:theName"
					+ " order by lastName", Customer.class);
			query.setParameter("theName", "%"+customerName+"%");
		}else {
			query = session.createQuery("from Customer order by lastName", Customer.class);
		}
		
		@SuppressWarnings("unchecked")
		List<Customer> customers = query.getResultList();
		return customers;
	}

}
