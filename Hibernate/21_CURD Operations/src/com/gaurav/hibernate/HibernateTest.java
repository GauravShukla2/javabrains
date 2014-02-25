package com.gaurav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// create
/*		  for(int i=1; i<11; i++){ 
		  UserDetails user = new UserDetails();
		  user.setUserName("User "+i); 
		  session.save(user); }*/
		 

		// retrieve
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		System.out.println("User name pulled : " + user.getUserName());

		// delete
		 session.delete(user);

		// update
		user.setUserName("My User 5");
		//session.update(user);

		session.getTransaction().commit();
		session.close();

	}

}
