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

		String minUserId = "5";
		String userName = "User 10";

		// 1.
		 Query query =
		 session.createQuery("from UserDetails where userId > ? and userName = ?");
		 query.setInteger(0, Integer.parseInt(minUserId));
		 query.setString(1, userName);

		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}

	}

}
