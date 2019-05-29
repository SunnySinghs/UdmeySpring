package com.sourabh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sourabh.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = ctx.getBean("accountDAO", AccountDAO.class);
		
		List<Account> myAccounts = null;
		try {
			myAccounts = account.findAccounts(false);
		}catch (Exception e) {
			System.out.println("Main Progeam >>>>>>>>>>handle exception"+e);
		}
		
		System.out.println("\n\n>>>>>Main Program>>>>>>AfterFinallyDemoApp");
		System.out.println(myAccounts+"\n");
		ctx.close();

	}

}
