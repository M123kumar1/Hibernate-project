package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.jdbc.beans.Store;
import com.jdbc.common.JndiConnectionFactory;

public class StoreInsert {
	private static final String INSERT_STORE_QUERY = "INSERT INTO STORE(store_number,store_name,contact_number,email_address,address_line1,address_line2,city,state,zip,country) values(?,?,?,?,?,?,?,?,?,?)";

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
