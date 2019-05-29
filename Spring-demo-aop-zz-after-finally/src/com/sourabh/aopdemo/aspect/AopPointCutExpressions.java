package com.sourabh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointCutExpressions {
	
	@Pointcut("execution(* com.sourabh.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.sourabh.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.sourabh.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !getter() && !setter()")
	public void forDaoPackageNoGetterSetter() {}
}
