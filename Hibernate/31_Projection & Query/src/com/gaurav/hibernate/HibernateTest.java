package com.gaurav.hibernate;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import com.gaurav.dto.UserDetails;

@SuppressWarnings("unused")
public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
/*		Criteria criteria = session.createCriteria(UserDetails.class)
							.setProjection(Projections.property("userId"));
*/
		
		UserDetails exampleUser = new UserDetails();
		// exampleUser.setUserId(5);
		exampleUser.setUserName("User 1%");

		Example example = Example.create(exampleUser).enableLike();

		Criteria criteria = session.createCriteria(UserDetails.class).add(example);

		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}

	}

}
