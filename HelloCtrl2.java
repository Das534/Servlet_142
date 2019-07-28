package com.maren.demosec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloCtrl2
 */
@WebServlet("/HelloCtrl2")
public class HelloCtrl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = (String) request.getAttribute("REQ");
		String ses = (String) request.getSession().getAttribute("SES");
		String app = (String) getServletContext().getAttribute("APP");
		PrintWriter out = response.getWriter();
		out.println("Request Scope" +req);
		out.println("Session Scope" +ses);
		out.println("Application Scope" +app);
	}
	}
