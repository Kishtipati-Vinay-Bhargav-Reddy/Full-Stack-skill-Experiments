package com.klef.hql.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klef.hql.entity.Product;
import com.klef.hql.util.HibernateUtil;

public class InsertProduct {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 65000, 10));
        session.save(new Product("Mobile", "Electronics", 30000, 15));
        session.save(new Product("Tablet", "Electronics", 20000, 8));
        session.save(new Product("Chair", "Furniture", 4000, 20));
        session.save(new Product("Table", "Furniture", 7000, 12));
        session.save(new Product("Pen", "Stationery", 20, 200));
        session.save(new Product("Notebook", "Stationery", 120, 150));

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully!");
    }
}

