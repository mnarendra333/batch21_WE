package com.pragim.ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		
		
			Map<String, String[]> parameterMap = request.getParameterMap();
			
			HttpSession exsSession = request.getSession(false);
			HttpSession session = request.getSession();
			session.setAttribute("form1", parameterMap.toString());
			
			response.setContentType("text/html");
			
			RequestDispatcher rd = request.getRequestDispatcher("form2.jsp");
			rd.include(request, response);
		
		
	}

}
