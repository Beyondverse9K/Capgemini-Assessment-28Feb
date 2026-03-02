package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {    
    public static void main(String[] args) {        
        Configuration cfg = new Configuration();        
        cfg.configure(); // Loads hibernate.cfg.xml
        cfg.addAnnotatedClass(Employee.class); // Corrected from Hibernate.class

        // Using try-with-resources for automatic closing of resources
        try (SessionFactory sf = cfg.buildSessionFactory();
             Session s = sf.openSession()) {
            
            // Start transaction at the beginning for all DML operations
            Transaction t = s.beginTransaction();
            
            System.out.println("--- 1. INSERT ---");
            // Ensure values match your Employee constructor: (id, name, email, mobile, salary)
            Employee emp = new Employee(3, "Arunabha Dutta", "tonikross19@keemail.de", 1234567890L, 55000.0);
            s.persist(emp); 
            System.out.println("Saved: " + emp);

            System.out.println("\n--- 2. READ ---");
            Employee fetched = s.find(Employee.class, 3);
            System.out.println("Fetched: " + fetched);

            System.out.println("\n--- 3. UPDATE ---");
            if (fetched != null) {
                fetched.setName("Dutta"); 
                // Hibernate performs 'Dirty Checking' and will update the DB on commit
                System.out.println("Updated Name: " + fetched.getName());
            }

            // Optional: Uncomment below if you actually want to delete the record immediately
            /*
            System.out.println("\n--- 4. DELETE ---");
            s.remove(fetched);
            System.out.println("Employee removed.");
            */

            // Commit all changes to the Database
            t.commit();
            System.out.println("\nTransaction committed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}