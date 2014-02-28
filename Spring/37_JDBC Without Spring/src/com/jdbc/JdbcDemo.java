package com.jdbc;

import com.jdbc.dao.JdbcDaoImpl;
import com.jdbc.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {

		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());

	}

}
