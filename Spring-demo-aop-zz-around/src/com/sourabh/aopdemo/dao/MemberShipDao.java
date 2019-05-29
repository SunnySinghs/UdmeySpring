package com.sourabh.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDao {

	public void addMembersAccount() {
		System.out.println(getClass() + " Add Member account.");
	}
}
