package com.metacube.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";	
	private static final String DRIVER = "com.mysql.jdbc.Driver";	
	private Connection con = null;
	public Connection getConnection() {
		/* register driver */
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
