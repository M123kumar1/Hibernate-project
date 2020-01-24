package com.jdbc.common;

import java.io.IOException;
import java.util.Properties;

import com.jdbc.sql.MySqlSQLPreparator;
import com.jdbc.sql.SQLPreparator;

public class SQLPreparatorFactory {
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
	public static SQLPreparator newSqlPreparator() {
		String className="";
		SQLPreparator sqlPreparator=null;
		Class<?> clazz=null;
		try {
			className=props.getProperty("sqlPreparator.class");
			clazz=Class.forName(className);
			sqlPreparator = (SQLPreparator) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlPreparator;
	}
}
