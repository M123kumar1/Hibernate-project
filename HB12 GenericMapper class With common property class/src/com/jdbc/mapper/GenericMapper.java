package com.jdbc.mapper;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Set;

public class GenericMapper {
	public static Object mapRowToObject(ResultSet rs,String entityClassName,Properties colToAttributeProps) throws Exception {
		Class<?> clazz=null;
		Object obj=null;
		String attributeName=null;
		String columnValue=null;
		String setterName=null;
		clazz=Class.forName(entityClassName);
		obj=clazz.newInstance();		
		for ( Object key: colToAttributeProps.keySet()) {
			String columnName = (String) key;
			attributeName=colToAttributeProps.getProperty(columnName);
			columnValue=rs.getString(columnName);
			setterName="set"+Character.toUpperCase(attributeName.charAt(0))+attributeName.substring(1);
			
			Method method=clazz.getDeclaredMethod(setterName, String.class);
			method.invoke(obj, columnValue);
		}
		return obj;
	}
}
//store.setStoreNo(rs.getInt("store_number"));