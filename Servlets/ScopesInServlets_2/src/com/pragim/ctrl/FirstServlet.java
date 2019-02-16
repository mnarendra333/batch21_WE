package com.pragim.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
			
		
		
		 String uname = request.getParameter("uname");
		 String age = request.getParameter("age");
		 String phno = request.getParameter("phno");
		 
		 
		 
		 //request scope
		 
		 request.setAttribute("key1", uname);
		 request.setAttribute("key2", age);
		 request.setAttribute("key3", phno);
		 
		 
		 //session scope
		 HttpSession session = request.getSession();
		 System.out.println(session.getId());
		 session.setAttribute("key4", uname);
		 session.setAttribute("key5", age);
		 session.setAttribute("key6", phno);
		 
		 
		 //context scope
		 ServletContext ctx = getServletContext();
		 ctx.setAttribute("key7", uname);
		 ctx.setAttribute("key8", age);
		 ctx.setAttribute("key9", phno);
		 
		 
		 
	}

}
