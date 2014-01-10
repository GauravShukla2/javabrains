package com.gaurav;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Triangle{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	public void draw() {
		System.out.println("Point A = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
		System.out.println("Point B = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
		System.out.println("Point C = (" + getPointC().getX() + ", " + getPointC().getY() + ")");
	}

	public void myInit() throws Exception {
		System.out.println("myInit() method called for Triangle");
		
	}

	public void cleanUp() throws Exception {
		System.out.println("cleanUp() method called for Triangle");
	}
	
/*	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean inti() method called for Triangle");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy() method called");
	}*/
}