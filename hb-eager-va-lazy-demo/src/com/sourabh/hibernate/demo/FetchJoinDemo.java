package com.sourabh.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sourabh.hibernate.demo.entity.InstructorDetail;
import com.sourabh.hibernate.demo.entity.Course;
import com.sourabh.hibernate.demo.entity.Instructor;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+" JOIN FETCH i.courses where i.id=:instuctorId ", Instructor.class);
			
			query.setParameter("instuctorId", 1);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("\n\n>>>>>>>>>instructor>>>>>>>>>>"+instructor);
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\n\nSession is closed");
			
			//if line 27 is not there then line 35 throws exception as data is not loaded lazily
			System.out.println("\n\n>>>>>>instructor Courses>>>"+instructor.getCourses());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}					
	}

}
