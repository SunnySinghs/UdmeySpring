package com.sourabh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sourabh.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = ctx.getBean("accountDAO", AccountDAO.class);
		
		List<Account> myAccounts = account.findAccounts();
		
		System.out.println("\n\n>>>>>Main Program>>>>>>");
		System.out.println(myAccounts+"\n");
		ctx.close();

	}

}
