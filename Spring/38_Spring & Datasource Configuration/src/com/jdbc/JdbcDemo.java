package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.JdbcDaoImpl;
import com.jdbc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());

	}

}
