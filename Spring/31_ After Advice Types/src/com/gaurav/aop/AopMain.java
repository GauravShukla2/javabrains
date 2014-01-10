package com.gaurav.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaurav.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService",	ShapeService.class);
		//shapeService.getCircle().setName("dummy");
		//2. 
		shapeService.getCircle().setNameandReturn("dummy");

	}

}
