package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	
	private Connection con;
	private PreparedStatement ps;
	
	//while loading
		public void init() {
			String sql="SELECT * FROM users WHERE email=? AND password=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
				ps=con.prepareStatement(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//while unloading
		public void destroy() {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//reading user-credentials
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		//authenticate from DB.
		try {
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			boolean b=rs.next();	
			if(b==true) {
				//valid
				response.sendRedirect("dashboard.jsp");
				//RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
				//rd.forward(request, response);
				
			}else {
				//invalid
				out.println("invalid user details");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
