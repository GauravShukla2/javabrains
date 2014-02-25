package com.gaurav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.dto.UserDetails;

public class HibernateTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		// user.setUserName("Updated User");

		// UserDetails user2 = (UserDetails)session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 1);

		session2.getTransaction().commit();
		session2.close();

	}

}
