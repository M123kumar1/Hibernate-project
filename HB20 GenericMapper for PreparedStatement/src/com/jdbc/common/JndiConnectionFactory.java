package com.jdbc.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JndiConnectionFactory {

	static Properties props = null;
	static {
		props = new Properties();
		try {
			props.load(JndiConnectionFactory.class.getClassLoader()
					.getResourceAsStream("com\\jdbc\\common\\persistence.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection newConnection() throws NamingException, SQLException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, props.getProperty("jndi.INITIAL_CONTEXT_FACTORY"));
		env.put(Context.PROVIDER_URL, props.getProperty("jndi.PROVIDER_URL"));
		env.put(Context.SECURITY_PRINCIPAL, props.getProperty("jndi.SECURITY_PRINCIPAL"));
		env.put(Context.SECURITY_CREDENTIALS, props.getProperty("jndi.SECURITY_CREDENTIALS"));
		
		Connection con = null;
		InitialContext context = new InitialContext(env);
		DataSource ds = (DataSource) context.lookup("mysqlJndi");
		con = ds.getConnection();
		return con;
	}
}
