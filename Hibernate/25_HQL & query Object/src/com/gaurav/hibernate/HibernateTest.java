package com.gaurav.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/*
		 for(int i=1; i<11; i++){ UserDetails user = new UserDetails();
		 user.setUserName("User "+i); session.save(user); }
		 */

		Query query = session.createQuery("from UserDetails where userId > 5");
		@SuppressWarnings("unchecked")
		List<UserDetails> users = query.list();

		session.getTransaction().commit();
		session.close();
		System.out.println("size of list: " + users.size());

	}

}
