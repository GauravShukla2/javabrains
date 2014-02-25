package com.gaurav.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.gaurav.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "User 10"));

		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}

	}

}
