package com.ssi;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TaxRateServlet")
public class TaxRateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		//response.setContentType("application/vnd.ms-excel");
		//response.setContentType("application/msword");
		
		//process the request (reading the data from an excel file)
		
		FileInputStream fis=new FileInputStream("g:\\data\\TaxRates.xlsx");
		int n=fis.available();		//gives you number of bytes available in stream.
		byte b[]=new byte[n];		//creating a byte array (size : no of bytes available)
		fis.read(b);				//read method will read the data and stores that to byte array.
		fis.close();            	//closing the stream
		
		//provides the response (to provide binary response, we use ServletOutputStream)
		
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		
	}

}
