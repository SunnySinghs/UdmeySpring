package com.sourabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.InstructorDetail;
import com.sourabh.hibernate.demo.entity.Review;
import com.sourabh.hibernate.demo.entity.Student;
import com.sourabh.hibernate.demo.entity.Course;
import com.sourabh.hibernate.demo.entity.Instructor;

public class CreateCourseForStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			
			Course course1 = new Course("ECE");
			Course course2 = new Course("EEE"); 
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}					
	}

}
