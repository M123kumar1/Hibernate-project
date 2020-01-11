package com.jdbc.common;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	

	public static Connection newConection(String driverClassName,String url,String userName,String password) {
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
