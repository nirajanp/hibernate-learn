package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.StudentEntity;

// Reason of creating this is that it is going to make use of the primary key 
// and auto increment feature. So each student will automatically get an new 
// id based on the auto incremented feature of MySql 
public class PrimaryKeyMain {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(StudentEntity.class)
										.buildSessionFactory();
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					
					// create 3 StudentEntity objects
					System.out.println("Creating 3 new student objects");
					StudentEntity tempStudent1 = new StudentEntity("John", "Doe", "john@code.com");
					StudentEntity tempStudent2 = new StudentEntity("Mary", "Jill", "mary@code.com");
					StudentEntity tempStudent3 = new StudentEntity("Rita", "Ora", "rita@luv2code.com");
					
					// Start a transaction
					session.beginTransaction();
					
					// save the StudentEntity object
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				} 
				finally {
					factory.close();
				}

	}

}
