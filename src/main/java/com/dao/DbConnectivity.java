package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectivity {

	private String url="jdbc:mysql://localhost:3306/****";
	private String userName="root";
	private String password="****";
	
	public Connection getConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			return con;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Mysql driver not loaded properly");
		return null;
	}
	
}
