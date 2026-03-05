package com.mapping;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        Customer c = new Customer(11,"Anirban");
//        CustomerDetails cd = new CustomerDetails(11,"Anirban","rhino@gmail.com",981234650L,55000);
//        c.setCustomerdetails(cd);
//        em.persist(c);
//        Customer c1 = new Customer(22,"Pushkar");
//        CustomerDetails cd1 = new CustomerDetails(22,"Pushkar","push@gmail.com",981234650L,55000);
//        c1.setCustomerdetails(cd1);
//        em.persist(c1);
//        Customer c2 = new Customer(33,"Jyotiraditya");
//        CustomerDetails cd2 = new CustomerDetails(33,"Jyotiraditya","jp@gmail.com",981234650L,55000);
//        c2.setCustomerdetails(cd2);
//        em.persist(c2);
//        Customer c3 = new Customer(44,"Subarna");
//        CustomerDetails cd3 = new CustomerDetails(44,"Subarna","golmukhfootball@gmail.com",981234650L,55000);
//        c3.setCustomerdetails(cd3);
//        em.persist(c3);
//        Customer c4 = new Customer(55,"Shubhangi");
//        CustomerDetails cd4 = new CustomerDetails(55,"Shubhnagi","subarna's_gf@gmail.com",981234650L,55000);
//        c4.setCustomerdetails(cd4);
//        em.persist(c4);
//        Customer c5 = new Customer(66,"Sumit");
//        CustomerDetails cd5 = new CustomerDetails(66,"Sumit","cocHugeMassive@gmail.com",981234650L,55000);
//        c5.setCustomerdetails(cd5);
//        em.persist(c5);
//        et.commit();
    	   EntityManager em = emf.createEntityManager();
	       EntityTransaction tx = em.getTransaction();
	       tx.begin();	      
	       //SELECT * FROM Employee
	       Query query = em.createQuery("SELECT e FROM CustomerDetails e");
	       List<CustomerDetails> list = query.getResultList();
	       for (CustomerDetails e : list) {
	       	System.out.println(e);
	       }
	       Query query2 = em.createQuery("UPDATE CustomerDetails e SET e.email='golmukhfootballrugby@gmail.com' WHERE e.name='Subarna'");
	       query2.executeUpdate();
	       List<CustomerDetails> list2 = query.getResultList();
	       for (CustomerDetails e : list2) {
		     System.out.println(e);
		   }
	       Query query1=em.createQuery("DELETE FROM CustomerDetails e where e.email='shush@gmail.com'");
	       query1.executeUpdate();
	       List<CustomerDetails> list1 = query.getResultList();
	       for (CustomerDetails e : list1) {
	       	System.out.println(e);
	       }
	       Query query3 = em.createQuery("SELECT e FROM CustomerDetails e");
	       List<CustomerDetails> list3 = query3.getResultList();
	       for (CustomerDetails e : list3) {
	       	System.out.println(e);
	       }
	       tx.commit();	      
	       emf.close();
    }
}
