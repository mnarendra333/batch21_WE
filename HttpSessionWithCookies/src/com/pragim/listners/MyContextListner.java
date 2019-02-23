package com.pragim.listners;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyContextListner
 *
 */
@WebListener
public class MyContextListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
	
	long startTime,endTine;
	
    public MyContextListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent ctxevent)  { 
         // TODO Auto-generated method stub
    	ServletContext ctx = ctxevent.getServletContext();
    	ctx.log("Application stopped : mail sent to the app team");
    	
    	ctx.log("application live status time is "+(System.currentTimeMillis() - startTime));
    	ctx.log("no of sesions are "+ctx.getAttribute("nos"));
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ctxevent)  { 
         // TODO Auto-generated method stub
    	
    	startTime = System.currentTimeMillis();
    	ServletContext ctx = ctxevent.getServletContext();
    	ctx.setAttribute("empNo", 101);
    	ctx.setAttribute("empName", "Surya");
    	ctx.log("Application started : mail sent to the app team");
    	ctx.log("starttime "+startTime);
    }
	
}
