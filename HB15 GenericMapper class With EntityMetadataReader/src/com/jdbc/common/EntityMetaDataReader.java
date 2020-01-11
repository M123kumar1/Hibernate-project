package com.jdbc.common;

import java.util.Properties;

import com.jdbc.beans.EntityMetaData;

public class EntityMetaDataReader {
	public static Properties readEntityMetaData(String fileName) {
		Properties props = PropertiesReader.readProps(fileName);
		EntityMetaData entityMetaData=new EntityMetaData();
		entityMetaData.setPkColumn(props.getProperty("pkColumn"));
		entityMetaData.setTableName(props.getProperty("tableName"));
		
		props.remove("pkColumn");
		props.remove("tableName");
		return props;
	}
}
