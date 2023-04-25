package com.google.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String URLNAME = "jdbc:mysql://localhost:3306/test1";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection()
	{
		Connection conn = null;
		
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
