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
		Connection connection = null;
		PreparedStatement ps = null;
		Properties props=null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		int count = 0;
		try {
			connection = JndiConnectionFactory.newConnection();
			entityMetaData=new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlSaveObject(entityMetaData);
			
			ps = connection.prepareStatement(sql);
			ps.setString(3, store.getStoreNumber());
			ps.setString(4, store.getStoreName());
			ps.setString(6, store.getContactNumber());
			ps.setString(8, store.getEmailAddress());
			ps.setString(10, store.getAddressLine1());
			ps.setString(9, store.getAddressLine2());
			ps.setString(7, store.getCity());
			ps.setString(1, store.getState());
			ps.setString(2, store.getZip());
			ps.setString(5, store.getCountry());
			count = ps.executeUpdate();
		} catch (NamingException | SQLException e) {
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
			con=JndiConnectionFactory.newConnection();
			entityMetaData=new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlUpdateObject(entityMetaData);
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getContactNumber());
			pstmt.setString(3, store.getEmailAddress());
			pstmt.setString(4, store.getAddressLine1());
			pstmt.setString(5, store.getAddressLine2());
			pstmt.setString(6, store.getCity());
			pstmt.setString(7, store.getState());
			pstmt.setString(8, store.getZip());
			pstmt.setString(9, store.getCountry());
			pstmt.setString(10, store.getStoreNumber());
			count = pstmt.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public void deleteStore(String storeNumber) {
		Connection connection = null;
		PreparedStatement ps = null;
		Properties props=null;
		EntityMetaData entityMetaData=null;
		SQLPreparator sqlPreparator=null;
		int count = 0;
		try {
			connection = JndiConnectionFactory.newConnection();
			entityMetaData=new EntityMetaData();
			props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
			entityMetaData.setPkColumn("store_number");
			entityMetaData.setTableName("store");
			entityMetaData.setColToAttributeProps(props);
			sqlPreparator=SQLPreparatorFactory.newSqlPreparator();
			String sql = sqlPreparator.sqlDeleteObject(entityMetaData);
			
			ps=connection.prepareStatement(sql);
			ps.setString(1, storeNumber);
			ps.executeUpdate();
		}catch(SQLException | NamingException e) {
			e.printStackTrace();
		}
		
	}
}
