package com.jdbc.test;

import com.jdbc.accessor.StaffAccessor;
import com.jdbc.beans.Staff;

public class StaffTest {
	public static void main(String[] args) throws Exception {
		StaffAccessor accessor=new StaffAccessor();
		Staff staff = accessor.staff("STF002");
		System.out.println(staff);
		
		/*
		 * List<Staff> staffList = accessor.staff(); for (Staff staff : staffList) {
		 * System.out.println(staff); }
		 */

		
	}
}
