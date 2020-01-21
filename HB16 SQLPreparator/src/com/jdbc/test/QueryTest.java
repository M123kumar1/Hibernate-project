package com.jdbc.test;

import java.util.Properties;

import com.jdbc.beans.EntityMetaData;
import com.jdbc.common.EntityMetaDataReader;
import com.jdbc.sql.SQLPreparator;

public class QueryTest {

	public static void main(String[] args) {
		EntityMetaData entityMetaData=new EntityMetaData();
		
		Properties props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
		
		entityMetaData.setPkColumn("store_number");
		entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		String sqlSelectObject = SQLPreparator.sqlSaveObject(entityMetaData);
		System.out.println(sqlSelectObject);
		
		/*entityMetaData.setPkColumn("store_number");
		entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		String sqlSelectObject = SQLPreparator.sqlSelectObjectByPkColumn(entityMetaData);
		System.out.println(sqlSelectObject);*/
		
		/*entityMetaData.setTableName("store");
		entityMetaData.setColToAttributeProps(props);
		String sqlSelectObject = SQLPreparator.sqlSelectObject(entityMetaData);
		System.out.println(sqlSelectObject);*/
	}

}
