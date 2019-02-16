package com.pragim.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		
		
		ServletConfig config = getServletConfig();
		Connection connection = null;
		
		String drivername = config.getInitParameter("driverClassName");
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		//read context params
		
		ServletContext servletContext = getServletContext();
		String no = servletContext.getInitParameter("eno");
		String name = servletContext.getInitParameter("ename");
		out.println("no is "+no+" name is "+name);
		/*try {
			Class.forName(drivername);
			connection = DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = connection.prepareStatement("insert into reg_data values(regi_seq.nextval,?,?,?)");
			
			pstmt.setString(1, request.getParameter("uname"));
			pstmt.setInt(2,Integer.parseInt( request.getParameter("age")));
			pstmt.setLong(3, Long.parseLong(request.getParameter("phno")));
			
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate>0){
				out.println("<h2>Reg Done!!</h2>");
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
	}

}
