package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.HibernateDaoImpl;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

		System.out.println(dao.getCircleCount());

	}

}
