package com.jdbc.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.beans.Sales;

public class SalesManagerDAO {
	public List<Sales> salesData(Date date, int qty) throws SQLException, ClassNotFoundException{
		Connection con = null;
		double grossAmt = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales sale=new Sales();
		List<Sales> sales=null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		ps = con.prepareStatement("select * from sales where sale_dt=? and qty<=?");
		ps.setDate(1, date);
		ps.setInt(2, qty);		
		rs=ps.executeQuery();
		sales=new ArrayList<>();
		while(rs.next()) {			
			sale.setCustomerName(rs.getString(1));
			sale.setDate(rs.getDate(2));
			sale.setQty(rs.getInt(3));
			sale.setDiscount(rs.getInt(4));
			sale.setTotalAmount(rs.getDouble(5));
			sale.setPaidAmount(rs.getDouble(6));
			sales.add(sale);
		}
		
		return sales;
	}
}
