package com.pragim.SpringDIWithObjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
    	Traveller traveller = ctx.getBean("id1",Traveller.class);
    	traveller.planTravel();
    }
}
