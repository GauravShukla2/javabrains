package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.JdbcDaoImpl;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

		// 1.
		System.out.println(dao.getCircleName(1));

		// 2.
		System.out.println(dao.getCircleforId(2).getId() + "\t" + dao.getCircleforId(2).getName());

		// 3.
		System.out.println(dao.getAllCircle().size());

	}

}
