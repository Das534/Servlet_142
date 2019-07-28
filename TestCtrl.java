package com.maren.demosec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestCtrl
 */
@WebServlet("/TestCtrl")
public class TestCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("REQ" , "Request Scope");
		request.getSession().setAttribute("SES" , "Session Scope");
		getServletContext().setAttribute("APP", "Application Scope");
		request.getRequestDispatcher("/TestCtrl2").forward(request , response);
		}

}
