package com.servlet;

import java.io.IOException;

import com.bean.AdminBean;
import com.dao.ResetPasswordDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/resetpassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPassword() {
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
			String name = request.getParameter("name");
			String password = request.getParameter("newpassword");
			AdminBean ab = new AdminBean();
			ResetPasswordDao rp = new ResetPasswordDao();
			ab.setEmail(name);
			ab.setPassword(password);
			int k = rp.resetPassword(ab);
			if (k != 0) {
				request.setAttribute("message", "Reset Password Successfull");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "Reset Password Fail");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ResetPassword.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
