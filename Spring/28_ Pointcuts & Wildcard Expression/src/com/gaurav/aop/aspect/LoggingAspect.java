package com.gaurav.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	//1.
	/*@Before("execution(* get*())")
	public void loggingAdvice(){
		System.out.println("Advice run. get() method called");
	}*/

	@Before("allGetters() && allCircleMethods()")
	public void loggingAdvice(){
		System.out.println("Advice run. get() method called");
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice executed");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	@Pointcut("within(com.gaurav.aop.model.Circle)")
	public void allCircleMethods(){}
	
	
}
