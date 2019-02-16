package com.pragim.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		 //get request scope
		 
		 String requname = (String)request.getAttribute("key1");
		 String reqage = (String)request.getAttribute("key2");
		 String reqphno = (String)request.getAttribute("key3");
		 out.println("request data \n 1.reqName"+requname+"\n 2.reqage "+reqage+"\n 3.phno "+reqphno);
		 
		 //session scope
		 HttpSession session = request.getSession();
		 System.out.println(session.getId());
		 String sesName = (String)session.getAttribute("key4");
		 String sesAge = (String)session.getAttribute("key5");
		 String sesPhno = (String)session.getAttribute("key6");
		 out.println("session data \n 1.reqName"+sesName+"\n 2.reqage "+sesAge+"\n 3.phno "+sesPhno);
		 
		 //context scope
		 ServletContext ctx = getServletContext();
		 String ctxName = (String)ctx.getAttribute("key7");
		 String ctxAge = (String)ctx.getAttribute("key8");
		 String ctxPhno = (String)ctx.getAttribute("key9");
		 out.println("context data \n 1.reqName"+ctxName+"\n 2.reqage "+ctxAge+"\n 3.phno "+ctxPhno);
	}

}
