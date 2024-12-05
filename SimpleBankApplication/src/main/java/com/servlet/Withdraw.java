package com.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bean.AdminBean;
import com.dao.WithdrawDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Withdraw() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			Long accno = Long.parseLong(request.getParameter("bankAccNo"));
			Double amount = Double.parseDouble(request.getParameter("amount"));
			String password = request.getParameter("password");

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter datefomatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String date = now.format(datefomatter);
			DateTimeFormatter timefomatter = DateTimeFormatter.ofPattern("hh:mm:ss");
			String time = now.format(timefomatter);

			AdminBean ab = new AdminBean();
			WithdrawDao wd = new WithdrawDao();
			ab.setBankAccNo(accno);
			ab.setAmount(amount);
			ab.setPassword(password);
			int k = wd.withdraw(ab, date,time);
			if (k != 0) {
				request.setAttribute("message", "Withdraw Successfull");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage2.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "Withdraw Fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Withdraw.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
