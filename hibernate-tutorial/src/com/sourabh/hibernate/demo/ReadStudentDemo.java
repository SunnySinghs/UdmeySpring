package com.sourabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			Student student = new Student("Tame", "High", "high@abc.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Saving Student:"+student);
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student tempStudent = session.get(Student.class, student.getId());
			session.getTransaction().commit();
			System.out.println("Retrieveing Student:"+tempStudent);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}					
	}

}
