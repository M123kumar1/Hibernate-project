package com.jdbc.mapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jdbc.beans.EntityMetaData;
import com.jdbc.beans.Store;
import com.jdbc.common.EntityMetaDataReader;

public class GenericMapper {
	public static Object mapRowToObject(ResultSet rs, String entityClassName, Properties colToAttributeProps) {
		Class<?> clazz = null;
		Object obj = null;
		String attributeName = null;
		String columnValue = null;
		String setterName = null;
		try {
			clazz = Class.forName(entityClassName);
			obj = clazz.newInstance();
			for (Object key : colToAttributeProps.keySet()) {
				String columnName = (String) key;
				attributeName = colToAttributeProps.getProperty(columnName);
				columnValue = rs.getString(columnName);

				setterName = "set" + Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1);

				Method method = clazz.getDeclaredMethod(setterName, String.class);
				method.invoke(obj, columnValue);
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return obj;

	}

//store.setStoreName(rs.getString("store_name"));
	public static PreparedStatement mapObjectToSavePreparedStatement(Connection con, String sql, Object object,
			EntityMetaData entityMetaData) {

		PreparedStatement pstmt = null;
		String columnName = null;
		String attributeName = null;
		String getterName = null;
		Class<?> clazz = null;
		String attributeValue = null;

		Properties colsToAttributeProps = entityMetaData.getColToAttributeProps();
		int count = 1;
		try {
			pstmt = con.prepareStatement(sql);

			for (Object key : colsToAttributeProps.keySet()) {
				columnName = (String) key;

				attributeName = colsToAttributeProps.getProperty(columnName);
				getterName = "get" + Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1);
				clazz = object.getClass();

				Method method = clazz.getDeclaredMethod(getterName, null);
				attributeValue = (String) method.invoke(object, null);

				pstmt.setString(count, attributeValue);
				count++;
			}
		} catch (SQLException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}

	public static PreparedStatement mapObjectToUpdatePreparedStatement(Connection con, String sql, Object object,
			EntityMetaData entityMetaData) {

		PreparedStatement pstmt = null;
		String columnName = null;
		String attributeName = null;
		String getterName = null;
		Class<?> clazz = null;
		String attributeValue = null;

		Properties colsToAttributeProps = null;
		Object id = null;
		int count = 1;
		try {
			pstmt = con.prepareStatement(sql);
			colsToAttributeProps = entityMetaData.getColToAttributeProps();
			for (Object key : colsToAttributeProps.keySet()) {
				columnName = (String) key;
				if (columnName.equals(entityMetaData.getPkColumn())) {
					continue;
				} else {
					attributeName = colsToAttributeProps.getProperty(columnName);
					getterName = "get" + Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1);
					clazz = object.getClass();

					Method method = clazz.getDeclaredMethod(getterName, null);
					attributeValue = (String) method.invoke(object, null);

					pstmt.setString(count, attributeValue);
				}
				count++;
			}
			pstmt.setString(count, attributeValue);
		} catch (SQLException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}

	public static PreparedStatement mapObjectToDeletePreparedStatement(Connection con, String sql, Object object,
			EntityMetaData entityMetaData) {

		PreparedStatement pstmt = null;
		String columnName = null;
		String attributeName = null;
		String getterName = null;
		Class<?> clazz = null;
		String className = null;
		String attributeValue = null;

		Properties colsToAttributeProps = entityMetaData.getColToAttributeProps();
		Object id = null;
		int count = 1;
		try {
			pstmt = con.prepareStatement(sql);

			for (Object key : colsToAttributeProps.keySet()) {
				columnName = (String) key;

				attributeName = colsToAttributeProps.getProperty(entityMetaData.getPkColumn());
				getterName = "get" + Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1);
				clazz = object.getClass();

				Method method = clazz.getDeclaredMethod(getterName, null);
				attributeValue = (String) method.invoke(object, null);

				pstmt.setString(count, attributeValue);
			}
			// pstmt.setString(count, attributeValue);
		} catch (SQLException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
}
