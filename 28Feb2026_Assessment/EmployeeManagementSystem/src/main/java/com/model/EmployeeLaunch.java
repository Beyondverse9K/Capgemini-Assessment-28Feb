package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeLaunch {	
	public static void main(String[] args) {		
		Configuration cfg = new Configuration();		
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("INSERT EMPLOYEE");
		Employee emp1 = new Employee(101, "Arunabha Dutta", "aryandutt@tuta.com", 9876543210L, 55000.00);
		Employee emp2 = new Employee(102, "Pushkar Ghosh", "lemon@outlook.com", 9876543211L, 60000.00);
		Employee emp3 = new Employee(103, "Anirban Mondal", "rhino@gmail.com", 9876543212L, 85000.00);
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);
		System.out.println(" Employee 1 inserted: " + emp1);
		System.out.println(" Employee 2 inserted: " + emp2);
		System.out.println(" Employee 3 inserted: " + emp3);
		System.out.println();
		transaction.commit();
		System.out.println("READ EMPLOYEE");
		transaction = session.beginTransaction();
		Employee fetchedEmp = session.get(Employee.class, 101);
		if (fetchedEmp != null) {
			System.out.println(" Employee found: " + fetchedEmp);
		} else {
			System.out.println(" Employee not found!");
		}
		System.out.println();
		System.out.println("UPDATE EMPLOYEE");
		Employee empToUpdate = session.get(Employee.class, 102);
		if (empToUpdate != null) {
			System.out.println("Before update: " + empToUpdate);
			empToUpdate.setSalary(75000.00); 
			session.merge(empToUpdate); 
			System.out.println("After update:  " + empToUpdate);
			System.out.println(" Salary updated successfully!");
		}
		System.out.println();
		transaction.commit();
		System.out.println("DELETE EMPLOYEE:");
		transaction = session.beginTransaction();
		Employee empToDelete = session.get(Employee.class, 103);
		if (empToDelete != null) {
			System.out.println("Deleting: " + empToDelete);
			session.remove(empToDelete);
			System.out.println("Employee deleted successfully!");
		}
		System.out.println();
		transaction.commit();
		transaction = session.beginTransaction();
		System.out.println("Checking Employee 101: " + session.get(Employee.class, 101));
		System.out.println("Checking Employee 102: " + session.get(Employee.class, 102));
		System.out.println("Checking Employee 103: " + session.get(Employee.class, 103));
		transaction.commit();
	}
}