package com.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bean.AdminBean;

public class BalanceCheckingDao {
	public List<AdminBean> balanceChecking(Long accno, String password) {
		List<AdminBean> list = null;
		try {
			String query = "SELECT amount FROM signup where accno=? and password=?";
			Properties p = new Properties();
			FileReader fr = new FileReader(
					"C:\\Sapthagiri\\ADVANCE JAVA\\Servlet Programs\\SimpleBankApplication\\src\\main\\webapp\\Connect.properties");
			p.load(fr);
			Class.forName(p.getProperty("driver"));
			Connection con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("dbUsername"),
					p.getProperty("dbPassword"));
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, accno);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				AdminBean ab = new AdminBean();
				ab.setAmount(rs.getDouble(1));
				list.add(ab);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
