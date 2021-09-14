package com.jdbcasmnt;

import java.sql.*;

public  class ConnectionJDBC {
	static Connection con;	
	public static Connection createCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydata";
			String user = "root";
			String pass = "yourpassword";
			con = DriverManager.getConnection(url,user,pass); 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return con;
		
	}
}
