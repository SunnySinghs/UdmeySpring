package com.sourabh.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

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
	
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	@Around("execution(* com.sourabh.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n\n Executing @Around Advice on method : "+ method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			
			result = "Major Accident! But don't worries, your private helicopter is on the way.";
			//throw e; //Throwing the exception back to calling program
		}
		
		long end = System.currentTimeMillis();
		
		myLogger.info("\n========> Duration: " +(end-begin)/1000.0 + " seconds");
		return result;
	}
	
	@After("execution(* com.sourabh.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n\n Executing @After (finally) Advice on method : "+ method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.sourabh.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc	) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n\n Executing @AfterThrowing Advice on method : "+ method);
		
		myLogger.info("\n\n The exception is : "+ theExc);
	}
	
	
	
	@AfterReturning(
			pointcut="execution(* com.sourabh.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n\n Executing @AfterReturning Advice on method : "+ method);
		
		myLogger.info("\n\nResult is : "+result);
		
		result.forEach(acc -> acc.setName(acc.getName().toUpperCase()));
	}
	
	@Before("com.sourabh.aopdemo.aspect.AopPointCutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		myLogger.info("\n\n Executing @Before Advice on addAccount");
	}
	
}
