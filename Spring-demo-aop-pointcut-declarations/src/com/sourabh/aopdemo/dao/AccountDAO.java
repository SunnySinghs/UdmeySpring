package com.sourabh.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + " Doing my DB work for adding account.");
	}
}
