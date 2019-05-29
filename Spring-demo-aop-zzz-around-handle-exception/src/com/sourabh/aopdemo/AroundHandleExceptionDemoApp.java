package com.sourabh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sourabh.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = ctx.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n\n>>>>>>>>>Main Program: AroundDemoApp");
		
		System.out.println(">>>>>>>>Calling GetFortune");
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		System.out.println(">>>>>>>>>My Fortune is : "+data);
		System.out.println("Finished");
		ctx.close();

	}

}
