package com.gaurav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Test User");    //Transient

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);    //Persistent

		user.setUserName("Updated User");
		user.setUserName("Updated User Again");
		session.getTransaction().commit();
		session.close();

		user.setUserName("Updated User after session closed");

	}

}
