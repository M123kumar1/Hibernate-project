package com.jdbc.dao;

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
import com.jdbc.mapper.GenericMapper;

public class StoreAccessor {
	private static final String INSERT_STORE_QUERY = "INSERT INTO STORE(store_number,store_name,contact_number,email_address,address_line1,address_line2,city,state,zip,country) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_STORE_QUERY="select * from store";
	private static final String GET_STORE_BY_STORE_NO_QUERY="select * from store where store_number=?";
	
	public List<Store> getStores() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Store> storeList = new ArrayList<Store>();
		try {
			con = JndiConnectionFactory.newConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(GET_STORE_QUERY);
			Properties props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");

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
		try {
			con = LocalConnectionFactory.newConnection();
			stmt = con.prepareStatement(GET_STORE_BY_STORE_NO_QUERY);
			stmt.setInt(1, storeNo);
			rs = stmt.executeQuery();
			Properties props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Store.properties");
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
		int count = 0;
		try {
			connection = JndiConnectionFactory.newConnection();
			ps = connection.prepareStatement(INSERT_STORE_QUERY);
			ps.setString(1, store.getStoreNumber());
			ps.setString(2, store.getStoreName());
			ps.setString(3, store.getContactNumber());
			ps.setString(4, store.getEmailAddress());
			ps.setString(5, store.getAddressLine1());
			ps.setString(6, store.getAddressLine2());
			ps.setString(7, store.getCity());
			ps.setString(8, store.getState());
			ps.setString(9, store.getZip());
			ps.setString(10, store.getCountry());
			count = ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
