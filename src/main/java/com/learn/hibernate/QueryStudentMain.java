package com.learn.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.StudentEntity;

public class QueryStudentMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(StudentEntity.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// query student table from db
			List<StudentEntity> students = session.createQuery("from StudentEntity").getResultList();
			
			displayStudents(students);
			
			// query student table, find student w/last name 'Doe'
			students = session.createQuery("from StudentEntity s where s.lastName='Doe'").getResultList();
			
			System.out.println("\n\nStudents who have lastName of Doe");
			displayStudents(students);
			
			// query staudent table: lastName='Doe' OR firstName='Daffy'
			students = session.createQuery("from StudentEntity s where"
					+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nStudents who have lastName of Doe and firstName of Daffy");
			displayStudents(students);
			
			// query students where email LIKE '%code.com'
			System.out.println("\n\nStudents whose email ending with code.com");
			students = session.createQuery("from StudentEntity s where s.email LIKE '%code.com'").getResultList();
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			} 
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<StudentEntity> students) {
		// display the students
		for(StudentEntity student: students) {
			System.out.println(student.toString());
		}
	}

}
