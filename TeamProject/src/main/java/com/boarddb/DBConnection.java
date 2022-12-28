package com.boarddb;

import java.sql.*;
import java.sql.Connection;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
			Connection conn = null;
			
			String url = "jdbc:mysql://localhost:3306/BBS";
			String user = "root";
			String password = "tiger";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			return conn;
	}
	
}
