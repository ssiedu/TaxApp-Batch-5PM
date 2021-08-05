package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
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
		//reads the request (userid,password,gender,hobbies,city,photo)
		String id=request.getParameter("userid");
		String pw=request.getParameter("password");
		String gn=request.getParameter("gender");
		String hobbies[]=request.getParameterValues("hobby");
		String city=request.getParameter("city");
		//process the requet
		
		
		//provides the response
		PrintWriter out=response.getWriter();
		out.println("registration processed...!");
		out.println(id);
		out.println(pw);
		out.println(gn);
		StringJoiner st=new StringJoiner("#");
		for(String hobby:hobbies) {
			st.add(hobby);
		}
		out.println(st);
		out.println(city);
	}

}
