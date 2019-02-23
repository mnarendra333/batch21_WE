package com.pragim.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyCtxList2
 *
 */
@WebListener
public class MyCtxList2 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyCtxList2() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent var1)  { 
         // TODO Auto-generated method stub
    	System.out.println("stopped");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent var1)  { 
         // TODO Auto-generated method stub
    	System.out.println("started...!");
    }
	
}
