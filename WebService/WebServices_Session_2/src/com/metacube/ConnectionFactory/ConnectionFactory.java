/*
 * Factory class to get connection object
 */
package com.metacube.ConnectionFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//to set url,user,password
	private static String DB_URL = "jdbc:mysql://localhost:3306/Employee";
	private static String user = "root";
	private static String password = "mysql";
	private static Connection connection = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Could not load driver class, please add mysql jdbc driver to classpath.");
		}
		try {
			connection = DriverManager.getConnection(DB_URL, user, password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Coult not create connection with database, [" + e.getMessage() + "]");
		}
		return connection;
	}
}
