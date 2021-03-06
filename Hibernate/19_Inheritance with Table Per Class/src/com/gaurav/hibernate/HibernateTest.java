package com.gaurav.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gaurav.dto.FourWheeler;
import com.gaurav.dto.TwoWheeler;
import com.gaurav.dto.UserDetails;
import com.gaurav.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("2-4 wheeler");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steering handle");

		FourWheeler car = new FourWheeler();
		car.setSteeringWheel("Porsche steering handle");
		car.setVehicleName("Car");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();

	}

}
