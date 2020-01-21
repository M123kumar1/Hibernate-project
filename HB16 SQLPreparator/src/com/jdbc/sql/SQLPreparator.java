package com.jdbc.sql;

import java.util.LinkedHashSet;

import com.jdbc.beans.EntityMetaData;

public class SQLPreparator {
	public static String sqlSelectObject(EntityMetaData entityMetaData) {
		StringBuffer buffer=null;
		boolean isFirst=true;
		
		buffer=new StringBuffer();
		buffer.append("select ");
		
		for(Object key:entityMetaData.getColToAttributeProps().keySet()) {
			String columnName=(String) key;
			if(isFirst) {
				buffer.append(columnName);
				isFirst=false;
			}
			else {
				buffer.append(",").append(columnName);
			}
		}
		buffer.append(" from ").append(entityMetaData.getTableName());
		return buffer.toString();
	}
}
//select store_number,store_name,contact_number,email_address,address_line1,address_line2,
//city,state,zip,country from store