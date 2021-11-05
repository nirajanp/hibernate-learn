package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.StudentEntity;

public class CreateStudentMain {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(StudentEntity.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create StudentEntity object
			System.out.println("Creating new student object");
			StudentEntity tempStudent = new StudentEntity("Paul", "Wall", "paul@luv2code.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// save the StudentEntity object
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		finally {
			factory.close();
		}

	}

}
