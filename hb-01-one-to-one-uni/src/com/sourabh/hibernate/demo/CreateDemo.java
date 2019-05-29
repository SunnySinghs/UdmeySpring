package com.sourabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.InstructorDetail;
import com.sourabh.hibernate.demo.entity.Instructor;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			Instructor instructor = new Instructor("Sourabh", "Singh", "foo@bar.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http:://www.youtube.com/sourabh", "Reading books");
			
			
/*Instructor instructor = new Instructor("Akki", "Kumar", "too@bar.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http:://www.youtube.com/akki", "Music");
			*/
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}					
	}

}
