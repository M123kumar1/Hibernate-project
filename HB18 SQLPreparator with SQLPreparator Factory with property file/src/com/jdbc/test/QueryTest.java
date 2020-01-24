package com.jdbc.test;

import java.util.Properties;

import com.jdbc.beans.EntityMetaData;
import com.jdbc.common.EntityMetaDataReader;
import com.jdbc.sql.MySqlSQLPreparator;
import com.jdbc.sql.SQLPreparator;

public class QueryTest {

	public static void main(String[] args) {
		EntityMetaData entityMetaData=null;
		Properties props=null;
		SQLPreparator sqlPreparator=null;
		String sql=null;
		
		entityMetaData=new EntityMetaData();		
		props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
		
		/*entityMetaData.setPkColumn("store_number");
		entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		sqlPreparator=new MySqlSQLPreparator();
		sql = sqlPreparator.sqlUpdateObject(entityMetaData);
		System.out.println(sql);*/
		
		/*entityMetaData.setPkColumn("store_number");
		entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		sqlPreparator=new MySqlSQLPreparator();
		sql = sqlPreparator.sqlDeleteObject(entityMetaData);
		System.out.println(sql);*/
		
		
		/*entityMetaData.setPkColumn("store_number");
		entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		sqlPreparator=new MySqlSQLPreparator();
		sql = sqlPreparator.sqlSelectObject(entityMetaData);
		System.out.println(sql);*/
		
		/*entityMetaData.setPkColumn("store_number");
		entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		sqlPreparator=new MySqlSQLPreparator();
		sql = sqlPreparator.sqlSelectObjectByColumn(entityMetaData);
		System.out.println(sql);;*/
		
		/*entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		sqlPreparator=new MySqlSQLPreparator();
		sql = sqlPreparator.sqlSelectObject(entityMetaData);
		System.out.println(sql);;*/
	}

}
