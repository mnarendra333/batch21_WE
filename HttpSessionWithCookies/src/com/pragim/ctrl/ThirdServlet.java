package com.pragim.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThirdServlet
 */
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = response.getWriter();
		
		//collect data from form-1
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String map1 = (String)session.getAttribute("form1");
		out.println("form1 data is "+map1);
		
		
		//collect data from form-2
		String map2 = (String)session.getAttribute("form2");
		out.println("form2 data is "+map2);
		
		//out.println("<form action="+response.encodeUrl("tsrv")+">");
		
		
		//collect data from form-3
		
		Map<String, String[]> map3 = request.getParameterMap();
		out.println("form3 data is "+map3);
		
		
		session.invalidate();
		
		
	}

}
