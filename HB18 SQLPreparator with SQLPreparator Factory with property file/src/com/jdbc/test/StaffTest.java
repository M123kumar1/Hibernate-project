package com.jdbc.test;

import com.jdbc.beans.Staff;
import com.jdbc.dao.StaffDAO;

public class StaffTest {
	public static void main(String[] args) throws Exception {
		StaffDAO accessor=new StaffDAO();
		Staff staff = accessor.staff("STF002");
		System.out.println(staff);
		
		/*
		 * List<Staff> staffList = accessor.staff(); for (Staff staff : staffList) {
		 * System.out.println(staff); }
		 */

		
	}
}
