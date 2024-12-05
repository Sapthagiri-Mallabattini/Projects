package com.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.bean.AdminBean;

public class LoginDao {
	public String login(String mailId, String password) {
		try {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			AdminBean ab = new AdminBean();

			String query = "select * from signup where MAILID=? and PASSWORD=?";
			Properties p = new Properties();
			FileReader fr = new FileReader(
					"C:\\Sapthagiri\\ADVANCE JAVA\\Servlet Programs\\SimpleBankApplication\\src\\main\\webapp\\Connect.properties");
			p.load(fr);
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("dbUsername"),
					p.getProperty("dbPassword"));
			if (con != null) {
				ps = con.prepareStatement(query);
			}
			if (ps != null) {
				ps.setString(1, mailId);
				ps.setString(2, password);
				rs = ps.executeQuery();
			}
			if (rs.next()) {
				String n = rs.getString("MailId");
				if (n != null) {
					ab.setEmail(mailId);
					ab.setPassword(password);
				}
				return n;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
