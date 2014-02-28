package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.JdbcDaoImpl;
import com.jdbc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

		dao.insertCircle(new Circle(4, "Forth Circle"));
		System.out.println(dao.getAllCircle().size());
		dao.createTriangleTable();

	}

}
