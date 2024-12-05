package com.servlet;

import java.io.IOException;

import com.bean.AdminBean;
import com.dao.LoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginservlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			AdminBean ab = new AdminBean();
			LoginDao ld = new LoginDao();
			ab.setEmail(mail);
			ab.setPassword(password);
			String k = ld.login(mail, password);
			if (k != null) {
				request.setAttribute("message", "Sign in Successfull");
				RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage2.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("message", "Invalid username/password");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
