package com.klef.hql.main;

import java.util.List;

import org.hibernate.Session;

import com.klef.hql.entity.Product;
import com.klef.hql.util.HibernateUtil;

public class HqlQueries {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // 1. Sort by price ASC
        List<Product> ascPrice =
                session.createQuery("from Product p order by p.price asc", Product.class)
                        .getResultList();

        System.out.println("---- Price Ascending ----");
        ascPrice.forEach(p -> System.out.println(p.getName() + " : " + p.getPrice()));

        // 2. Sort by price DESC
        List<Product> descPrice =
                session.createQuery("from Product p order by p.price desc", Product.class)
                        .getResultList();

        System.out.println("---- Price Descending ----");
        descPrice.forEach(p -> System.out.println(p.getName() + " : " + p.getPrice()));

        // 3. Quantity highest first
        List<Product> qty =
                session.createQuery("from Product p order by p.quantity desc", Product.class)
                        .getResultList();

        System.out.println("---- Quantity High to Low ----");
        qty.forEach(p -> System.out.println(p.getName() + " : " + p.getQuantity()));

        // 4. Pagination (first 3)
        List<Product> page1 =
                session.createQuery("from Product", Product.class)
                        .setFirstResult(0)
                        .setMaxResults(3)
                        .getResultList();

        System.out.println("---- First 3 Products ----");
        page1.forEach(p -> System.out.println(p.getName()));

        // 5. Aggregate queries
        Long count =
                session.createQuery("select count(p) from Product p", Long.class)
                        .uniqueResult();

        System.out.println("Total Products: " + count);

        Double minPrice =
                session.createQuery("select min(p.price) from Product p", Double.class)
                        .uniqueResult();

        Double maxPrice =
                session.createQuery("select max(p.price) from Product p", Double.class)
                        .uniqueResult();

        System.out.println("Min Price: " + minPrice);
        System.out.println("Max Price: " + maxPrice);

        session.close();
    }
}

