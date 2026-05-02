package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        // INSERT OPERATION
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product(
                "Laptop",
                "Gaming Laptop",
                new Date(),
                "Available",
                85000.0
        );

        session.save(p);
        tx.commit();
        session.close();

        System.out.println("Product Inserted Successfully!");

        // UPDATE OPERATION
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();

        int productId = 1; // change as needed
        Product product = session2.get(Product.class, productId);

        if(product != null)
        {
            product.setName("Updated Laptop");
            product.setStatus("Out of Stock");

            session2.update(product);
            System.out.println("Product Updated Successfully!");
        }
        else
        {
            System.out.println("Product Not Found!");
        }

        tx2.commit();
        session2.close();
    }
}