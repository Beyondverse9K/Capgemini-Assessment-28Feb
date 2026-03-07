package com.hib2.Hibernate2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class CustomerDAOImpl {
    private final EntityManager em;
    public CustomerDAOImpl(EntityManager em) {
        this.em = em;
    }
    public void saveCustomer(Customer customer) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(customer); // CascadeType.ALL will automatically save the Order
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
    public void updateCustomer(Customer customer) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
    public void deleteCustomer(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Customer customer = em.find(Customer.class, id);
            if (customer != null) {
                em.remove(customer); // CascadeType.ALL will also delete the associated Order
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
    public Customer getCustomerById(int id) {
        return em.find(Customer.class, id);
    }
    public List<Customer> getAllCustomers() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
    public Customer getCustomerByEmail(String email) {
        String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
        return em.createQuery(jpql, Customer.class)
                 .setParameter("email", email)
                 .getSingleResult();
    }
}