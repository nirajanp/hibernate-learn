package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.StudentEntity;

public class ReadStudentMain {

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
			StudentEntity tempStudent = new StudentEntity("Daffy", "Duck", "dafy@code.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// save the StudentEntity object
			System.out.println("Saving the student ...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// CODE TO READ
			// find out student's id: PK
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			StudentEntity myStudent = session.get(StudentEntity.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
								
			System.out.println("Done!");
		} 
		finally {
			factory.close();
		}

	}

}
