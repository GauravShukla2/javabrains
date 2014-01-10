package com.gaurav.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.gaurav.aop.model.Circle;

@Aspect
public class LoggingAspect {
	

	@Before("allCircleMethods()")
	public void loggingAdvice0(JoinPoint joinPoint){
		Circle c = (Circle)joinPoint.getTarget();
		System.out.println("Name: "+c.getName());
	}
	
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println(joinPoint.toString());
	}
	
	@Before("args(name)")
	public void stringArgumentMethod(String name){
		System.out.println("A method that takes String argument has been called. Value is "+name);
	}
	
	
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	@Pointcut("within(com.gaurav.aop.model.Circle)")
	public void allCircleMethods(){}
	
	
}
