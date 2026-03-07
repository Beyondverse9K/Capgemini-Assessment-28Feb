package com.hib2.Hibernate2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderDAOImpl {
    private final EntityManager em;
    public OrderDAOImpl(EntityManager em) {
        this.em = em;
    }
    public void updateOrder(Order order) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(order);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
    public Order getOrderById(int id) {
        return em.find(Order.class, id);
    }
}