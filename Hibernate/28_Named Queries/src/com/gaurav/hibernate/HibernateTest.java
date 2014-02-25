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

		Query q = session.getNamedQuery("UserDetails.byId");
		q.setInteger(0, 1);
		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) q.list();

		Query q2 = session.getNamedQuery("UserDetails.byName");
		q2.setString(0, "User 7");
		@SuppressWarnings("unchecked")
		List<UserDetails> users2 = (List<UserDetails>) q2.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}

		for (UserDetails u : users2) {
			System.out.println(u.getUserName());
		}

	}

}
