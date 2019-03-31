package com.pragim.SpringAWWithAnnotations;

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
    	Person person = ctx.getBean("person",Person.class);
    	person.doWork();
    }
}
