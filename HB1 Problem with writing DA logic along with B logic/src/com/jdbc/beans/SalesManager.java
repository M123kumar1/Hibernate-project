package com.jdbc.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesManager {
	public double grossSale(Date date, int qty) throws ClassNotFoundException, SQLException {
		Connection con = null;
		double grossAmt = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		ps = con.prepareStatement("select * from sales where sale_dt=? and qty<=?");
		ps.setDate(1, date);
		ps.setInt(2, qty);
		
		rs=ps.executeQuery();
		
		while (rs.next()) {
			grossAmt = grossAmt + rs.getDouble(6);
			
		}
		return grossAmt;
	}
}
