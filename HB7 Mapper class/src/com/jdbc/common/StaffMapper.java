package com.jdbc.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.beans.Staff;

public class StaffMapper {
		public static Staff mapResultSettoStaff(ResultSet rs) throws SQLException {
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
			return staff;
			
		}
}
