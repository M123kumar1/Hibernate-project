package com.jdbc.accessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.beans.Staff;
import com.jdbc.beans.Store;
import com.jdbc.common.ConnectionFactory;

public class StaffAccessor {
	public List<Staff> getStaff() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Staff> staffList = new ArrayList<Staff>();
		try {
			con = ConnectionFactory.newConection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from staff");

			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffNumber(rs.getString("staff_number"));
				staff.setStaffFirstName(rs.getString("staff_first_name"));
				staff.setStaffLastName(rs.getString("staff_last_name"));
				staff.setDesignation(rs.getString("designation"));
				staff.setMobileNumber(rs.getString("mobile_number"));
				staff.setEmailAddress(rs.getString("email_address"));
				staff.setAddressLine1(rs.getString("address_line1"));
				staff.setAddressLine2(rs.getString("address_line2"));
				staff.setCity(rs.getString("city"));
				staff.setState(rs.getString("state"));
				staff.setZip(rs.getInt("zip"));
				staff.setCountry(rs.getString("country"));
				staff.setRoleNo(rs.getInt("role_number"));
				staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}

	public Staff getStaffByNumber(String staffNo) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Store> stores = null;
		Staff staff = null;

		try {
			con = ConnectionFactory.newConection();
			stmt = con.prepareStatement("select * from staff where staff_number=?");
			stmt.setString(1, staffNo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				staff = new Staff();
				staff.setStaffNumber(rs.getString("staff_number"));
				staff.setStaffFirstName(rs.getString("staff_first_name"));
				staff.setStaffLastName(rs.getString("staff_last_name"));
				staff.setDesignation(rs.getString("designation"));
				staff.setMobileNumber(rs.getString("mobile_number"));
				staff.setEmailAddress(rs.getString("email_address"));
				staff.setAddressLine1(rs.getString("address_line1"));
				staff.setAddressLine2(rs.getString("address_line2"));
				staff.setCity(rs.getString("city"));
				staff.setState(rs.getString("state"));
				staff.setZip(rs.getInt("zip"));
				staff.setCountry(rs.getString("country"));
				staff.setRoleNo(rs.getInt("role_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}
}
