package com.ssi;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/pdf");
		
		//will read the pdf-file
		FileInputStream fis=new FileInputStream("g:\\data\\info.pdf");
		int n=fis.available();		//gives you number of bytes available in stream.
		byte b[]=new byte[n];		//creating a byte array (size : no of bytes available)
		fis.read(b);				//read method will read the data and stores that to byte array.
		fis.close();            	//closing the stream
		
		//will send the pdf-contents to client
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		
		
		
	}

}
