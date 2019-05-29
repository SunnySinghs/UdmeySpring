package com.sourabh.aopdemo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.sourabh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n\n Executing @Before Advice on addAccount");
		
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Singnature is : "+signature);
		
		Object[] args = theJoinPoint.getArgs();
		Arrays.asList(args).forEach(System.out::println);
	}
	
}
