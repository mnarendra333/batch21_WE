package com.pragim.ctrl;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for (Cookie cookie : cookies) {
				response.getWriter().println(cookie.getName()+" is "+cookie.getValue());
			}
		}
		for (Entry<String, String[]> entry : entrySet) {
			response.getWriter().println(entry.getKey()+" is "+entry.getValue()[0]);
		}
		
		
		
		
		
	}

}