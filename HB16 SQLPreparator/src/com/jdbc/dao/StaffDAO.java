package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdbc.beans.Staff;
import com.jdbc.common.EntityMetaDataReader;
import com.jdbc.common.LocalConnectionFactory;
import com.jdbc.common.PropertiesReader;
import com.jdbc.mapper.GenericMapper;

public class StaffDAO {
	//private static final String INSERT_STAFF_QUERY = "INSERT INTO STORE(store_number,store_name,contact_number,email_address,address_line1,address_line2,city,state,zip,country) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_STAFF_QUERY="select * from staff";
	private static final String GET_STORE_BY_STAFF_NO_QUERY="select * from staff where staff_number = ?";
	
	public List<Staff> staff() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Staff> lStaff = null;
	
		lStaff = new ArrayList<Staff>();
		try {
			con = LocalConnectionFactory.newConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(GET_STAFF_QUERY);
			
			Properties props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Staff.properties");
			
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
			stmt = con.prepareStatement(GET_STORE_BY_STAFF_NO_QUERY);
			stmt.setString(1, staffNo);
			rs = stmt.executeQuery();
			
			Properties props = EntityMetaDataReader.readEntityMetaData("com\\jdbc\\common\\Staff.properties");
			
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
