package com.pragim.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//collect the data from form-1
		
		String uname = request.getParameter("uname");
		String fatname = request.getParameter("fname");
		String dob = request.getParameter("dob");
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<form action=ssrv>"
				+ "<input type=hidden name=name value="+uname+">"
				+ "<input type=hidden name=fname value="+fatname+">"
				+"<input type=hidden name=dob value="+dob+">"
				+ "<table><tr><td>Income</td><td><input type=number name=income></td></tr>");
		out.println("<tr><td>Tax</td><td><input type=number name=tax></td></tr>");
		out.println("<tr><td><input type=submit value=submit></td></tr></table></form>");
		
		out.println("");
		out.println("");
		
		
		
		
		
	}

}
