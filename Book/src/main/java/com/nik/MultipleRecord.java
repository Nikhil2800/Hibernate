package com.nik;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MultipleRecord {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		String sql = "from Book";
		Query query = session.createQuery(sql);
		List<Book> book = query.getResultList();
		
		for(Book b1:book) {
			System.out.println("ID is "+b1.getId()+" Name is "+b1.getName() +" Price is "+b1.getPrice());
		}
		tr.commit();
		session.close();
	}

}
