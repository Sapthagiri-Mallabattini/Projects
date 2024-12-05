package com.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.bean.AdminBean;

public class ResetPasswordDao {
	public int resetPassword(AdminBean ab) {
		try {
			String query = "update signup set password=? where mailid=?";
			Properties p = new Properties();
			FileReader fr = new FileReader(
					"C:\\Sapthagiri\\ADVANCE JAVA\\Servlet Programs\\SimpleBankApplication\\src\\main\\webapp\\Connect.properties");
			p.load(fr);
			Class.forName(p.getProperty("driver"));
			Connection con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("dbUsername"),
					p.getProperty("dbPassword"));
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ab.getPassword());
			ps.setString(2, ab.getEmail());
			int k = ps.executeUpdate();
			return k;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
