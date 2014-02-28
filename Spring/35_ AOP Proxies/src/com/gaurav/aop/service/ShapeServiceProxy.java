package com.gaurav.aop.service;

import com.gaurav.aop.aspect.LoggingAspect;
import com.gaurav.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		System.out.println("ShapeServiceProxy.getCircle() called");
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
