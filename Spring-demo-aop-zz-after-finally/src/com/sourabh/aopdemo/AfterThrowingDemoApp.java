package com.sourabh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sourabh.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = ctx.getBean("accountDAO", AccountDAO.class);
		
		List<Account> myAccounts = null;
		try {
			account.findAccounts(true);
		}catch (Exception e) {
			System.out.println("Main Progeam >>>>>>>>>>handle exception"+e);
		}
		
		System.out.println("\n\n>>>>>Main Program>>>>>>AfterThrowingDemoApp");
		System.out.println(myAccounts+"\n");
		ctx.close();

	}

}
