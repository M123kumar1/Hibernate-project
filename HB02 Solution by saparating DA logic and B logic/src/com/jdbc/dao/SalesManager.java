package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jdbc.beans.Sales;
import com.jdbc.service.SalesManagerDAO;

public class SalesManager {
	SalesManagerDAO dao;
	public double grossSale(Date date, int qty) throws ClassNotFoundException, SQLException {
		dao=new SalesManagerDAO();
		int count=0;
		List<Sales> salesData = dao.salesData(date, qty);
		double grossAmount=0;
		for (Sales sale1 : salesData) {
			grossAmount=grossAmount+sale1.getPaidAmount();
			count++;
		}
		double average=grossAmount/count;
		System.out.println(average);
		return grossAmount;		
	}
}
