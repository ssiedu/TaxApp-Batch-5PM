package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//reads the request (userid,password,gender,hobbies,city,photo)
		String id=request.getParameter("userid");
		String pw=request.getParameter("password");
		String gn=request.getParameter("gender");
		String hobbies[]=request.getParameterValues("hobby");
		String city=request.getParameter("city");
		StringJoiner sj=new StringJoiner("#");
		if(hobbies!=null) {
			for(String hobby:hobbies) {
				sj.add(hobby);
			}
		}else {
			sj.add("NotMentioned");
		}
		String hobby=sj.toString();
		//process the request
		String sql="INSERT INTO users VALUES(?,?,?,?,?)";
		out.println("<html>");
		out.println("<body>");
		out.println("<hr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, hobby);
			ps.setString(4, city);
			ps.setString(5, gn);
			ps.executeUpdate();
			con.close();
			out.println("<h3>Registered Successfully</h3>");
			out.println("<h4><a href=index.jsp>Login</a></h4>");
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h3>Registration Failed</h3>");
			out.println("<h4><a href=registration.jsp>Re-Try</a></h4>");
			out.println("<h4><a href=index.jsp>Home</a></h4>");
		}
		out.println("<hr>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
