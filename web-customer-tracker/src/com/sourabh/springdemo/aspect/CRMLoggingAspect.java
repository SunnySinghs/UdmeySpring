package com.sourabh.springdemo.aspect;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sourabh.springdemo.entity.Customer;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.sourabh.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.sourabh.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.sourabh.springdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("===> @Before : Calling Method: "+method);
		
		Object[] args = joinPoint.getArgs(); 
		
		Arrays.asList(args).forEach(System.out::println);
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, List<Customer> result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("===> @afterReturning : Calling Method: "+method);
		
		logger.info("===> result : "+result);
	}

}
