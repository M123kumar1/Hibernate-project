package com.jdbc.test;

import com.jdbc.accessor.StaffAccessor;
import com.jdbc.beans.Staff;

public class StaffTest {

	public static void main(String[] args) {
		StaffAccessor accessor=new StaffAccessor();
		Staff staffByNumber = accessor.getStaffByNumber("STF003");
		System.out.println(staffByNumber);
		/*
		 * List<Staff> staffList = accessor.getStaff(); for (Staff staff : staffList) {
		 * System.out.println(staffList); }
		 */
	}

}
