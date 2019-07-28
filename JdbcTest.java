package com.jwt.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class JdbcTest {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3360/test","root","root");
			st = con.createStatement();
			Resultset rs = (Resultset) st.executeQuery("SELECT * from test.login");
			while(((ResultSet) rs).next()) {
				long id = ((ResultSet) rs).getLong("id");
				String us = ((ResultSet) rs).getString("userid");
				String ps = ((ResultSet) rs).getString("password");
				String tp = ((ResultSet) rs).getString("type");
				System.out.println("\nID:" +id+ "\nUSERID" +us+ "\nPASSWORD" +ps+ "\nTYPE" +tp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
}
