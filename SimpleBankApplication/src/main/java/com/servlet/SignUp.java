package com.servlet;

import java.io.IOException;

import com.bean.AdminBean;
import com.dao.SignUpDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	static int k;
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SignUp() {
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
			String username = request.getParameter("username");
			Long bankAccNo=Long.parseLong(request.getParameter("bankAccNo"));
			String transactionId=request.getParameter("transactionid");
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			AdminBean ab = new AdminBean();
			SignUpDao su = new SignUpDao();
			ab.setUsername(username);
			ab.setBankAccNo(bankAccNo);
			ab.setTransactionId(transactionId);
			ab.setEmail(mail);
			ab.setPassword(password);
			k = su.signUp(ab);
			if (k != 0) {
				request.setAttribute("message", "SignUp Successfull");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "SignUp Fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
