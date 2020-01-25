package com.jdbc.common;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class LocalConnectionFactory {
	
	static Properties props=null;
	static {
		props=new Properties();
		try {
			props.load(LocalConnectionFactory.class.getClassLoader().getResourceAsStream("com\\jdbc\\common\\persistence.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection newConnection() {
		Connection con = null;
		try {
			Class.forName(props.getProperty("db.driver"));
			con = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
