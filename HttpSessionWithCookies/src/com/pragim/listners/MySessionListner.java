package com.pragim.listners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListner
 *
 */
@WebListener
public class MySessionListner implements HttpSessionListener {

	long startTime;
	int counter;
    /**
     * Default constructor. 
     */
    public MySessionListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent hse)  { 
         // TODO Auto-generated method stub
    	++counter;
    	
    	startTime = System.currentTimeMillis();
    	ServletContext ctx = hse.getSession().getServletContext();
    	ctx.log("session created st "+startTime);
    	ctx.setAttribute("nos", counter);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent hse)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext ctx = hse.getSession().getServletContext();
    	ctx.setAttribute("nos", (Integer)ctx.getAttribute("nos")-1);
    	ctx.log("session stopped st "+startTime);
    	ctx.log("session meantime is "+(System.currentTimeMillis() - startTime));
    	
    	
    	
    }
	
}
