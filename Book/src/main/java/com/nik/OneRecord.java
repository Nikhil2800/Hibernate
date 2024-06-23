package com.nik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneRecord {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Book book = session.get(Book.class, 1);
		if(book!=null) {
			System.out.println("Id is "+book.getId()+" Name is "+book.getName() +" price is "+book.getPrice());
		}else {
			System.out.println("Record Was Not Found");
		}
		
		tr.commit();
		session.close();
	}

}
