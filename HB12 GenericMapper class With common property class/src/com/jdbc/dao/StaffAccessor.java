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

import com.jdbc.beans.Staff;
import com.jdbc.common.LocalConnectionFactory;
import com.jdbc.mapper.GenericMapper;

public class StaffAccessor {

	public List<Staff> staff() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Staff> lStaff = null;
	
		lStaff = new ArrayList<Staff>();
		try {
			con = LocalConnectionFactory.newConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from staff");
			Properties props=new Properties();
			while (rs.next()) {
				Staff staff = (Staff) GenericMapper.mapRowToObject(rs, "com.jdbc.beans.Staff", props);
				lStaff.add(staff);
			}

		} catch (Exception e) {

		}
		return lStaff;
	}

	public Staff staff(String staffNo) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Staff staff = null;
		try {
			con = LocalConnectionFactory.newConnection();
			stmt = con.prepareStatement("select * from staff where staff_number = ?");
			stmt.setString(1, staffNo);
			rs = stmt.executeQuery();
			Properties props=new Properties();
			while (rs.next()) {
				staff = new Staff();
				staff = (Staff) GenericMapper.mapRowToObject(rs, "com.jdbc.beans.Staff", props);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}
}
