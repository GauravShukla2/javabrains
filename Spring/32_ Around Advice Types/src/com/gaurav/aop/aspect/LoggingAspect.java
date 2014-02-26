package com.gaurav.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void stringArgumentMethod(String name, String returnString) {
		System.out.println("A method that takes String argument has been called. Value is " + name);
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("An Exception has been thrown");
	}

	@Around(value = "allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After finally");
		return returnValue;
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("within(com.gaurav.aop.model.Circle)")
	public void allCircleMethods() {
	}

}
