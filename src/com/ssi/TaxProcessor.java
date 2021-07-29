package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TaxProcessor")
public class TaxProcessor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reads-the-data
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		
		//process-the-data (tax compute)
		int tax=0;
		int income=Integer.parseInt(s1);
		int age=Integer.parseInt(s2);
		if(income>=500000) {
			tax=income*20/100;
		}else {
			tax=income*10/100;
		}
		
		if(age>=60) {
			tax=tax-(tax*10/100);
		}
		
		//provides-the-response
		//to provide the response we need a PrintWriter object.
		PrintWriter out=response.getWriter();
		//to send any thing to client in response call the println method on PrintWriter object.
		out.println("Thanks For Visiting Us..");
		out.println("Your Tax Amount : "+tax);
		out.println("Pay Your Taxes On Time..");
		
	}

}
