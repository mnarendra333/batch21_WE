package com.pragim.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		/*String uname = request.getParameter("uname");
		String fatname = request.getParameter("fname");
		String dob = request.getParameter("dob");*/
		
		Set<Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();
		
		for (Entry<String, String[]> entry : entrySet) {
			Cookie cookie = new Cookie(entry.getKey(), entry.getValue()[0]);
			response.addCookie(cookie);
		}
		
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		RequestDispatcher rd = request.getRequestDispatcher("form2.html");
		rd.include(request, response);
		
		RequestDispatcher rd2 = request.getRequestDispatcher("form3.html");
		rd2.include(request, response);
		
		
		
		
		
		
	}

}