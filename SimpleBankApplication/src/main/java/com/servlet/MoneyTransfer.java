package com.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bean.AdminBean;
import com.dao.MoneyTransferDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoneyTransfer
 */
@WebServlet("/moneytransfer")
public class MoneyTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoneyTransfer() {
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
			String transactionId = request.getParameter("transactionid");
			Long toAccNo = Long.parseLong(request.getParameter("toaccno"));
			Double amount = Double.parseDouble(request.getParameter("amount"));

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter datefomatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String date = now.format(datefomatter);
			DateTimeFormatter timefomatter = DateTimeFormatter.ofPattern("hh:mm:ss");
			String time = now.format(timefomatter);

			MoneyTransferDao mt = new MoneyTransferDao();
			AdminBean ab = new AdminBean();
			ab.setBankAccNo(accNo);
			ab.setTransactionId(transactionId);
			ab.setAmount(amount);
			int k = mt.moneyTransfer(ab, toAccNo, date,time);
			if (k != 0) {
				request.setAttribute("message", "Money Transfer Successfull");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage2.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "Money Transfer Fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("MoneyTransfer.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
