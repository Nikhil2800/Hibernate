package com.nik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class create 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       SessionFactory sf = cfg.buildSessionFactory();
       Session session = sf.openSession();
       Transaction tr = session.beginTransaction();
       Book book = new Book();
       book.setId(1);
       book.setName("Electrical Machine");
       book.setPrice(500);
      System.out.println("Table is Created and Value is Added...");
       session.persist(book);
       tr.commit();
       session.close();
    }
}
