package com.gaurav.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.gaurav.dto.UserDetails;

public class HibernateTest {

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query q = session.createQuery("from UserDetails where userId = 1");
		q.setCacheable(true);
		List<UserDetails> users = q.list();

		session.getTransaction().commit();
		session.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		Query q2 = session2.createQuery("from UserDetails where userId = 1");
		q2.setCacheable(true);
		users = q2.list();

		session2.getTransaction().commit();
		session2.close();

	}

}
