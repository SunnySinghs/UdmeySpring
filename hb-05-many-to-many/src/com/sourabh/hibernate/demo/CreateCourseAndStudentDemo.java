package com.sourabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sourabh.hibernate.demo.entity.InstructorDetail;
import com.sourabh.hibernate.demo.entity.Review;
import com.sourabh.hibernate.demo.entity.Student;
import com.sourabh.hibernate.demo.entity.Course;
import com.sourabh.hibernate.demo.entity.Instructor;

public class CreateCourseAndStudentDemo {

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
			
			Course course1 = new Course("CSE");
			session.save(course1);
			
			Student student1 = new Student("Sourabh", "Singh", "s@s.com");
			Student student2 = new Student("Akki", "Kumar", "a@a.com");
			
			course1.addStudent(student1);
			course1.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}					
	}

}
