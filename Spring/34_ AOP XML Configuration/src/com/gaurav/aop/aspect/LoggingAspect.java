package com.gaurav.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

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

	public void allGetters() {
	}

}
