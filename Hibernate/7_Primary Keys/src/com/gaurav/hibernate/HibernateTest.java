package com.gaurav.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.gaurav.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		user.setJoinedDate(new Date());
		user.setAddress("Hyderabad");
		user.setDescription("This is description");
		
		UserDetails user2 = new UserDetails();
		//user2.setUserId(1);
		user2.setUserName("Second User");
		user2.setJoinedDate(new Date());
		user2.setAddress("Hyderabad2");
		user2.setDescription("This is description2");
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		

	}

}
