package com.jdbc.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.beans.Store;

public class StoreMapper {
		public static Store mapResultSetRecordToStore(ResultSet rs) throws SQLException {
			Store store = new Store();
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
			
			return store;
			
		}
}
