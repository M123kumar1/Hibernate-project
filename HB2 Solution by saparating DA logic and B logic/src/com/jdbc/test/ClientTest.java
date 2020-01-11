package com.jdbc.test;

import java.sql.SQLException;
import java.util.Date;

import com.jdbc.dao.SalesManager;

public class ClientTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SalesManager salesManager=new SalesManager();
		Date uDate=new Date("10-DEC-19");
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		double grossSale = salesManager.grossSale(sDate, 5);
		System.out.println(grossSale);
	}

}
