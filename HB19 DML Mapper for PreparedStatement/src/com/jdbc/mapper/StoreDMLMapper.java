package com.jdbc.mapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.jdbc.beans.EntityMetaData;
import com.jdbc.beans.Store;

public class StoreDMLMapper {
	public static PreparedStatement mapObjectToUpdatePreparedStatement(Connection con, String sql, Store store) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, store.getStoreName());
			ps.setString(2, store.getContactNumber());
			ps.setString(3, store.getEmailAddress());
			ps.setString(4, store.getAddressLine1());
			ps.setString(5, store.getAddressLine2());
			ps.setString(6, store.getCity());
			ps.setString(7, store.getState());
			ps.setString(8, store.getZip());
			ps.setString(9, store.getCountry());
			ps.setString(10, store.getStoreNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	public static PreparedStatement mapObjectToSavePreparedStatement(Connection con, String sql, Store store) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	public static PreparedStatement mapObjectToDeletePreparedStatement(Connection con, String sql, String storeNumber) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, storeNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
}
