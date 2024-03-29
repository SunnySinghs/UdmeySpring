package com.sourabh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Student> student = session.createQuery("from Student").getResultList();
			student.forEach(System.out::println);
			
			student = session.createQuery("from Student where firstName like '%sou%'").getResultList();
			student.forEach(System.out::println);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}					 	
	}

}
