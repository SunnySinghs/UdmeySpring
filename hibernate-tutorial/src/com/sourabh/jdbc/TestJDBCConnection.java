package com.sourabh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBCConnection {

	public static void main(String[] args) {
		
		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			Connection connection = DriverManager.getConnection(jdbcurl, user, password);
			
			System.out.println("Successfull Connection");
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
