package com.gaurav;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// 1. Triangle triangle = (Triangle) context.getBean("triangle1");
		Triangle triangle = (Triangle) context.getBean("triangle1");
		triangle.draw();

	}
}
