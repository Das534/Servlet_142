package com.jwt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String us = request.getParameter("user");
		String ps = request.getParameter("pass");
		Connection con = null;
		Statement st = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3360/login","root","root");
				st = con.createStatement();
				st.executeUpdate("Insert Into login.login ("+us+","+ps+")");
				
				Resultset rs = (Resultset) st.executeQuery("SELECT * from login.login");
				while(((ResultSet) rs).next()) {
					String user = ((ResultSet) rs).getString("us");
					String pass = ((ResultSet) rs).getString("ps");
					System.out.println("\nUSERID" +us+ "\nPASSWORD" +ps );
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
