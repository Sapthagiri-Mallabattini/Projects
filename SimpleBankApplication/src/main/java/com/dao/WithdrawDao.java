package com.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.bean.AdminBean;

public class WithdrawDao {
	public int withdraw(AdminBean ab, String date,String time) {
		try {
			String query1 = "insert into transaction values(?, ?, ?, ?, ?, ?, ?)";
			String query2 = "update signup set amount = amount - ? where accno = ?";
			Properties p = new Properties();
			FileReader fr = new FileReader(
					"C:\\Sapthagiri\\ADVANCE JAVA\\Servlet Programs\\SimpleBankApplication\\src\\main\\webapp\\Connect.properties");
			p.load(fr);
			Class.forName(p.getProperty("driver"));
			Connection con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("dbUsername"),
					p.getProperty("dbPassword"));
			PreparedStatement ps = con.prepareStatement(query1);

			ps.setString(1, date);
			ps.setString(2, time);
			ps.setLong(3, ab.getBankAccNo());
			ps.setString(4, ab.getTransactionId());
			ps.setString(5, "Withdraw");
			ps.setString(6, null);
			ps.setDouble(7, ab.getAmount());

			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setDouble(1, ab.getAmount());
			ps2.setLong(2, ab.getBankAccNo());
			ps2.executeUpdate();
			int k = ps.executeUpdate();
			return k;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
