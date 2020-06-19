package com.longnguyen.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {

	public static Connection getConnection() {
		
		final String data = "jdbc:mysql://localhost:3306/SERVLET_CMD";
		final String useName = "root";
		final String passWord = "long250599";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(data,useName,passWord);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
