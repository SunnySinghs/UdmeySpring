package com.sourabh.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sourabh.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.sourabh.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n\n Executing @Around Advice on method : "+ method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("\n========> Duration: " +(end-begin)/1000.0 + " seconds");
		return result;
	}
	
	@After("execution(* com.sourabh.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n Executing @After (finally) Advice on method : "+ method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.sourabh.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc	) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n Executing @AfterThrowing Advice on method : "+ method);
		
		System.out.println("\n\n The exception is : "+ theExc);
	}
	
	
	
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
