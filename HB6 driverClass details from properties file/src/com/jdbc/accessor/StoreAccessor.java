package com.jdbc.accessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.beans.Store;
import com.jdbc.common.ConnectionFactory;

public class StoreAccessor {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<Store> storeList = null;

	public List<Store> getStores() {
		Store store = null;
		List<Store> storeList = new ArrayList<Store>();
		try {

			con = ConnectionFactory.newConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from store");

			while (rs.next()) {
				store = new Store();
				store.setStoreNo(rs.getInt("store_number"));
				store.setStoreName(rs.getString("store_name"));
				store.setContactNo(rs.getString("contact_number"));
				store.setEmailAddress(rs.getString("email_address"));
				store.setAddressLine1(rs.getString("address_line1"));
				store.setAddressLine2(rs.getString("address_line2"));
				store.setCity(rs.getString("city"));
				store.setState(rs.getString("state"));
				store.setZip(rs.getInt("zip"));
				store.setCountry(rs.getString("country"));
				storeList.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storeList;

	}

	public Store getStore(int storeNo) {
		Store store = null;
		try {
			con = ConnectionFactory.newConnection();
			PreparedStatement stmt = con.prepareStatement("select * from store where store_number=?");
			stmt.setInt(1, storeNo);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				store = new Store();
				store.setStoreNo(rs.getInt("store_number"));
				store.setStoreName(rs.getString("store_name"));
				store.setContactNo(rs.getString("contact_number"));
				store.setEmailAddress(rs.getString("email_address"));
				store.setAddressLine1(rs.getString("address_line1"));
				store.setAddressLine2(rs.getString("address_line2"));
				store.setCity(rs.getString("city"));
				store.setState(rs.getString("state"));
				store.setZip(rs.getInt("zip"));
				store.setCountry(rs.getString("country"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;

	}
}
