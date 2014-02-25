package com.gaurav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.gaurav.dto.Address;
import com.gaurav.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		
		Address address = new Address();
		address.setCity("Hyderabad");
		address.setState("AP");
		address.setPincode("500084");
		
		Address address2 = new Address();
		address2.setCity("Bangalore");
		address2.setState("KA");
		address2.setPincode("560068");
		
		user.getListOfAddresses().add(address);
		user.getListOfAddresses().add(address2);
		
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
