package com.pragim.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		ServletConfig config = this.getServletConfig();
		Connection connection = null;
		
		String drivername = config.getInitParameter("driverClassName");
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		PrintWriter out = response.getWriter();
		
		out.println("drivername is "+drivername);
		
		out.println("url is "+url);
		
		out.println("username is "+username);
		
		out.println("password is "+password);
		
		
		ServletContext servletContext = getServletContext();
		String no = servletContext.getInitParameter("eno");
		String name = servletContext.getInitParameter("ename");
		out.println("no is "+no+" name is "+name);
	}

}
