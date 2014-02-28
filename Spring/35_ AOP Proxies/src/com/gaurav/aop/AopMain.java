package com.gaurav.aop;

import com.gaurav.aop.service.FactoryService;
import com.gaurav.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();
	}

}
