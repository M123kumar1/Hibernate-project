package com.jdbc.beans;

import java.util.Properties;

public class EntityMetaData {
	private String pkColumn;
	private String tableName;
	private Properties colToAttributeProps;

	public String getPkColumn() {
		return pkColumn;
	}

	public void setPkColumn(String pkColumn) {
		this.pkColumn = pkColumn;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Properties getColToAttributeProps() {
		return colToAttributeProps;
	}

	public void setColToAttributeProps(Properties colToAttributeProps) {
		this.colToAttributeProps = colToAttributeProps;
	}
}
