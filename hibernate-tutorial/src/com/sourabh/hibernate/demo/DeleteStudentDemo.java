package com.sourabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, 1);
			
			session.delete(tempStudent);
			
			session.createQuery("delete from Student where email = 'high@abc.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Retrieveing Student:"+tempStudent);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}					
	}

}
