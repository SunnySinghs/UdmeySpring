package com.sourabh.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sourabh.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@AfterReturning(
			pointcut="execution(* com.sourabh.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n Executing @AfterReturning Advice on method : "+ method);
		
		System.out.println("\n\nResult is : "+result);
		
		result.forEach(acc -> acc.setName(acc.getName().toUpperCase()));
	}
	
	@Before("com.sourabh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n Executing @Before Advice on addAccount");
	}
	
}
