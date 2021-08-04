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
		//to provide the response we need a PrintWriter object.
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=pink>");
		out.println("<h3>Your Tax Details</h3>");
		out.println("<h4>Thanks For Visiting Us..<h4>");
		out.println("<hr>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td>Income</td>");
		out.println("<td>"+income+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Tax</td>");
		out.println("<td>"+tax+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<hr>");
		out.println("<marquee>Pay Your Taxes On Time..</marquee>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
