package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bean.AdminBean;
import com.dao.BalanceCheckingDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BalanceChecking
 */
@WebServlet("/balancechecking")
public class BalanceChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BalanceChecking() {
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
		PrintWriter pw = response.getWriter();
		try {
			Long accNo = Long.parseLong(request.getParameter("bankAccNo"));
			String password = request.getParameter("password");
			BalanceCheckingDao bc = new BalanceCheckingDao();
			List<AdminBean> list = bc.balanceChecking(accNo, password);
			if (list != null && !list.isEmpty()) {
				pw.print("<html><body align='center' text='red' padding=100>");
				for (AdminBean ab : list) {
					pw.print("<h2> Balance: " + ab.getAmount() + "</h2>");
				}

				pw.print("<a href='HomePage2.jsp'>Go To HomePage>></a>");
				pw.print("</body></html>");
			} else {
				pw.print("<html><body align='center'>");
				pw.print("<h1>No records found or invalid credentials</h1>");
				pw.print("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
