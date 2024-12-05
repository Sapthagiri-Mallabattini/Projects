package com.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bean.AdminBean;
import com.dao.DepositDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Deposit() {
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
			Long accNo = Long.parseLong(request.getParameter("accno"));
			Double amount = Double.parseDouble(request.getParameter("amount"));

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter datefomatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String date = now.format(datefomatter);
			DateTimeFormatter timefomatter = DateTimeFormatter.ofPattern("hh:mm:ss");
			String time = now.format(timefomatter);

			DepositDao dd = new DepositDao();
			AdminBean ab = new AdminBean();
			ab.setBankAccNo(accNo);
			ab.setAmount(amount);
			int k = dd.deposit(ab, date, time);
			if (k != 0) {
				request.setAttribute("message", "Deposit Successfull");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage2.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "Deposit Fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Deposit.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
