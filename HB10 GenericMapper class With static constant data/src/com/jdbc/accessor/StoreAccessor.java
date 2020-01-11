package com.jdbc.accessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdbc.beans.Store;
import com.jdbc.common.DBProperties;
import com.jdbc.common.JndiConnectionFactory;
import com.jdbc.common.LocalConnectionFactory;
import com.jdbc.mapper.GenericMapper;

public class StoreAccessor {

	public List<Store> getStores() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Store> storeList = new ArrayList<Store>();
		try {

			con = JndiConnectionFactory.newConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from store");
			
			while (rs.next()) {
				Store store = (Store) GenericMapper.mapRowToObject(rs, "com.jdbc.beans.Store", DBProperties.STORE_PROPS);
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
			stmt = con.prepareStatement("select * from store where store_number=?");
			stmt.setInt(1, storeNo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				store = new Store();
				store = (Store) GenericMapper.mapRowToObject(rs, "com.jdbc.beans.Store", DBProperties.STORE_PROPS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;

	}
}
