package com.jdbc.sql;

import java.util.LinkedHashSet;

import com.jdbc.beans.EntityMetaData;

public class SQLPreparator {
	public static String sqlSelectObject(EntityMetaData entityMetaData) {
		StringBuffer buffer = null;
		boolean isFirst = true;

		buffer = new StringBuffer();
		buffer.append("select ");

		for (Object key : entityMetaData.getColToAttributeProps().keySet()) {
			String columnName = (String) key;
			if (isFirst) {
				buffer.append(columnName);
				isFirst = false;
			} else {
				buffer.append(",").append(columnName);
			}
		}
		buffer.append(" from ").append(entityMetaData.getTableName());
		return buffer.toString();
	}

	public static String sqlSelectObjectByPkColumn(EntityMetaData entityMetaData) {
		StringBuffer buffer = null;
		boolean isFirst = true;

		buffer = new StringBuffer();
		buffer.append("select ");

		for (Object key : entityMetaData.getColToAttributeProps().keySet()) {
			String columnName = (String) key;
			if (isFirst) {
				buffer.append(columnName);
				isFirst = false;
			} else {
				buffer.append(",").append(columnName);
			}
		}
		buffer.append(" from ").append(entityMetaData.getTableName()).append(" where ")
				.append(entityMetaData.getPkColumn()).append("=?");
		return buffer.toString();
	}

	public static String sqlSaveObject(EntityMetaData entityMetaData) {
		StringBuffer buffer = null;
		boolean isFirst = true;

		buffer = new StringBuffer();
		buffer.append("insert into ").append(entityMetaData.getTableName()).append("(");

		for (Object key : entityMetaData.getColToAttributeProps().keySet()) {
			String columnName = (String) key;
			if (isFirst) {
				buffer.append(columnName);
				isFirst = false;
			} else {
				buffer.append(",").append(columnName);
			}
		}
		buffer.append(")").append(" values(");
		isFirst = true;
		for (int i = 0; i < entityMetaData.getColToAttributeProps().size(); i++) {
			if (isFirst) {
				buffer.append("?");
				isFirst = false;
			} else {
				buffer.append(",?");
			}
		}
		buffer.append(")");
		return buffer.toString();
	}

	public static String sqlUpdateObject(EntityMetaData entityMetaData) {
		StringBuffer buffer = null;
		boolean isFirst = true;
		buffer = new StringBuffer();
		buffer.append("update ").append(entityMetaData.getTableName()).append(" set ");
		for (Object key : entityMetaData.getColToAttributeProps().keySet()) {
			String columnName = (String) key;
			if (columnName.equals(entityMetaData.getPkColumn())) {

				continue;
			} else {
				if (isFirst) {
					buffer.append(columnName).append("=?");
					isFirst = false;
				} else {
					buffer.append(",").append(columnName).append("=?");
				}
			}
		}
		buffer.append(" where ").append(entityMetaData.getPkColumn()).append("=?");
		return buffer.toString();
	}

	// UPDATE STORE SET
	// store_name=?,contact_number=?,email_address=?,address_line1=?,
	// address_line2=?,city=?,state=?,zip=?,country=? where store_number=?
	public static String sqlDeleteObject(EntityMetaData entityMetaData) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		buffer.append("delete from ").append(entityMetaData.getTableName()).append(" where ")
				.append(entityMetaData.getPkColumn()).append("=?");

		return buffer.toString();
	}
}
//delete from store where store_number=?

//INSERT INTO STORE(store_number,store_name,contact_number,email_address,address_line1,
//address_line2,city,state,zip,country) values(?,?,?,?,?,?,?,?,?,?)

//select store_number,store_name,contact_number,email_address,address_line1,address_line2,
//city,state,zip,country from store