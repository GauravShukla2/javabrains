package com.gaurav.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	

	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint){
		//System.out.println(joinPoint.toString());
	}
	
	//1.
	@AfterReturning("args(name)")
	public void stringArgumentMethod(String name){
		System.out.println("A method that takes String argument has been called. Value is "+name);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name){
		System.out.println("An Exception has been thrown");
	}	
	
	//2.
	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void stringArgumentMethod(String name, String returnString){
		System.out.println("A method that takes String argument has been called. Argument Value is "+name);
	}
	
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex){
		System.out.println("An Exception has been thrown");
	}
	

	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	@Pointcut("within(com.gaurav.aop.model.Circle)")
	public void allCircleMethods(){}
	
	
}
