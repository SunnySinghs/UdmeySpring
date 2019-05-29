package com.sourabh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	@Before("com.sourabh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println(" perform API Analytics");
	}
}
