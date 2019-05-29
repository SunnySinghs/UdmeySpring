package com.sourabh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLogAspect {

	@Before("com.sourabh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
	public void LogException() {
		System.out.println(" Logging Exception");
	}
}
