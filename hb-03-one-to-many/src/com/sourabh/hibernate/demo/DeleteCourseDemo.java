package com.sourabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.InstructorDetail;
import com.sourabh.hibernate.demo.entity.Course;
import com.sourabh.hibernate.demo.entity.Instructor;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 10);
			
			System.out.println("\n\n>>>>>>>>>>"+course);
			
			session.delete(course);
			
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}					
	}

}
