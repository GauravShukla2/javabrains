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
		 * for(int i=1; i<11; i++){ UserDetails user = new UserDetails();
		 * user.setUserName("User "+i); session.save(user); }
		 */

		Query query = session.createQuery("from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);

		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) query.list();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}

		session.getTransaction().commit();
		session.close();

	}

}
