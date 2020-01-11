package com.jdbc.common;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	private static Properties props=null;
	static {
		props=new Properties();
		try {
			props.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("com\\jdbc\\common\\db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection newConection() {
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
