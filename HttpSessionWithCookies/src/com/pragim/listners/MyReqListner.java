package com.pragim.listners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyReqListner
 *
 */
@WebListener
public class MyReqListner implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyReqListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	ServletContext ctx = sre.getServletContext();
    	ctx.log("requested destroyed at--- "+(System.currentTimeMillis()));
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	ServletContext ctx = sre.getServletContext();
    	ctx.log("requested created at--- "+(System.currentTimeMillis()));
    }
	
}
