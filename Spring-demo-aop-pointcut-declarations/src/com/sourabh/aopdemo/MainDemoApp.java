package com.sourabh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sourabh.aopdemo.dao.AccountDAO;
import com.sourabh.aopdemo.dao.MemberShipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = ctx.getBean("accountDAO", AccountDAO.class);
		MemberShipDao member = ctx.getBean("memberShipDao", MemberShipDao.class);
		
		account.addAccount();
		member.addMembersAccount();
		
		ctx.close();

	}

}
