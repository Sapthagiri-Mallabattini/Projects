package com.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.bean.AdminBean;

public class SignUpDao {
	public int signUp(AdminBean ab) {
		try {
			String query = "insert into signup values(?, ?, ?, ?, ?, 0.0)";
			Properties p = new Properties();
			FileReader fr = new FileReader(
					"C:\\Sapthagiri\\ADVANCE JAVA\\Servlet Programs\\SimpleBankApplication\\src\\main\\webapp\\Connect.properties");
			p.load(fr);
			Class.forName(p.getProperty("driver"));
			Connection con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("dbUsername"),
					p.getProperty("dbPassword"));
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ab.getUsername());
			ps.setLong(2, ab.getBankAccNo());
			ps.setString(3, ab.getTransactionId());
			ps.setString(4, ab.getPassword());
			ps.setString(5, ab.getEmail());
			int k = ps.executeUpdate();
			return k;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
