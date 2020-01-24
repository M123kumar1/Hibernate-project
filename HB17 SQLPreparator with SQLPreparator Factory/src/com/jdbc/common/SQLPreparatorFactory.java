package com.jdbc.common;

import com.jdbc.sql.MySqlSQLPreparator;
import com.jdbc.sql.SQLPreparator;

public class SQLPreparatorFactory {
	public static SQLPreparator newSqlPreparator() {
		SQLPreparator sqlPreparator=new MySqlSQLPreparator();
		return sqlPreparator;
	}
}
