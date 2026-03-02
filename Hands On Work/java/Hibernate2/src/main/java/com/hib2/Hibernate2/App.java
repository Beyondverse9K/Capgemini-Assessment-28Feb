package com.hib2.Hibernate2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		System.out.println("INSERT EMPLOYEE");
		Employee emp1 = new Employee("Arunabha Dutta", "aryandutt@tuta.com", 9876543210L, 55000.00);
		Employee emp2 = new Employee("Pushkar Ghosh", "lemon@outlook.com", 9876543211L, 60000.00);
		Employee emp3 = new Employee("Anirban Mondal", "rhino@gmail.com", 9876543212L, 85000.00);
		Employee emp4 = new Employee("Anirban Mondal", "rhino@gmail.com", 9855543212L, 85000.00);
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		System.out.println(" Employee 1 inserted: " + emp1);
		System.out.println(" Employee 2 inserted: " + emp2);
		System.out.println(" Employee 3 inserted: " + emp3);
		System.out.println(" Employee 4 inserted: " + emp4);
		System.out.println();
		et.commit();
		System.out.println("READ EMPLOYEE");
		et.begin();
		Employee fetchedEmp = em.get(Employee.class, 1);
		if (fetchedEmp != null) {
			System.out.println(" Employee found: " + fetchedEmp);
		} else {
			System.out.println(" Employee not found!");
		}
		System.out.println();
		System.out.println("UPDATE EMPLOYEE");
		Employee empToUpdate = em.get(Employee.class, 2);
		if (empToUpdate != null) {
			System.out.println("Before update: " + empToUpdate);
			empToUpdate.setSalary(75000.00); 
			em.merge(empToUpdate); 
			System.out.println("After update:  " + empToUpdate);
			System.out.println(" Salary updated successfully!");
		}
		System.out.println();
		et.commit();
		System.out.println("DELETE EMPLOYEE:");
		et.begin();
		Employee empToDelete = em.get(Employee.class, 4);
		if (empToDelete != null) {
			System.out.println("Deleting: " + empToDelete);
			em.remove(empToDelete);
			System.out.println("Employee deleted successfully!");
		}
		System.out.println();
		et.commit();
		et.begin();
		System.out.println("Checking Employee 1: " + em.get(Employee.class, 1));
		System.out.println("Checking Employee 2: " + em.get(Employee.class, 2));
		System.out.println("Checking Employee 3: " + em.get(Employee.class, 3));
		System.out.println("Checking Employee 4: " + em.get(Employee.class, 4));
		et.commit();
	}
}