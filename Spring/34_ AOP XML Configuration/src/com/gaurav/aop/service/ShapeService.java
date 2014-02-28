package com.gaurav.aop.service;

import com.gaurav.aop.aspect.Loggable;
import com.gaurav.aop.model.Circle;
import com.gaurav.aop.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	@Loggable
	public Circle getCircle() {
		System.out.println("ShapeService.getCircle() called");
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
