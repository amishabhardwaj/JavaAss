package com.hsbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection conn = null;

	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TestDB1");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}