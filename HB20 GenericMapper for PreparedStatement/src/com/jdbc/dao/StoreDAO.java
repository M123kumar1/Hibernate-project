package com.jdbc.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;

import com.jdbc.beans.EntityMetaData;
import com.jdbc.beans.Store;
import com.jdbc.common.EntityMetaDataReader;
import com.jdbc.common.JndiConnectionFactory;
import com.jdbc.common.LocalConnectionFactory;
import com.jdbc.common.PropertiesReader;
import com.jdbc.common.SQLPreparatorFactory;
import com.jdbc.mapper.GenericMapper;
import com.jdbc.sql.MySqlSQLPreparator;
import com.jdbc.sql.SQLPreparator;

public class StoreDAO {
	//private static final String INSERT_STORE_QUERY = "INSERT INTO STORE(store_number,store_name,contact_number,email_address,address_line1,address_line2,city,state,zip,country) values(?,?,?,?,?,?,?,?,?,?)";
	//private static final String GET_STORE_QUERY="select * from store";
	//private static final String GET_STORE_BY_STORE_NO_QUERY="select * from store where store_number=?";
	//private static final String UPDATE_STORE_QUERY="UPDATE STORE SET store_name=?,contact_number=?,email_address=?,address_line1=?,address_line2=?,city=?,state=?,zip=?,country=? where store_number=?";
	
	public List<Store> getStores() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		Properties props=null;
		List<Store> storeList = new ArrayList<Store>();
		try {
			con = JndiConnectionFactory.newConnection();
			stmt = con.createStatement();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");

			entityMetaData=new EntityMetaData();
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlSelectObject(entityMetaData);
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Store store = (Store) GenericMapper.mapRowToObject(rs, "com.jdbc.beans.Store", props);
				storeList.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return storeList;

	}

	public Store getStore(int storeNo) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Store store = null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		Properties props=null;
		try {
			con = LocalConnectionFactory.newConnection();
			entityMetaData = new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlSelectObject(entityMetaData);
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, storeNo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				store = new Store();
				store = (Store) GenericMapper.mapRowToObject(rs, "com.jdbc.beans.Store", props);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;

	}

	public int saveStore(Store store) {
		Connection con = null;
		PreparedStatement ps = null;
		Properties props=null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		int count = 0;
		try {
			con = LocalConnectionFactory.newConnection();
			entityMetaData=new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			//entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlSaveObject(entityMetaData);
			ps = GenericMapper.mapObjectToSavePreparedStatement(con, sql, store, entityMetaData);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int updateStore(Store store) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Properties props=null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		int count=0;
		try {
			con=LocalConnectionFactory.newConnection();
			entityMetaData=new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlUpdateObject(entityMetaData);
			pstmt=GenericMapper.mapObjectToUpdatePreparedStatement(con, sql, store, entityMetaData);			
			
			count = pstmt.executeUpdate();
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int deleteStore(Store store) {
		Connection con = null;
		PreparedStatement ps = null;
		Properties props=null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		int count=0;
		String sql=null;
		try {
			con = LocalConnectionFactory.newConnection();
			entityMetaData=new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			sql = sqlPreparator.sqlDeleteObject(entityMetaData);
			
			ps=GenericMapper.mapObjectToDeletePreparedStatement(con, sql, store, entityMetaData);
			
			count=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
