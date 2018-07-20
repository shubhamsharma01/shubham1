package com.nucleus;

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
       
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("springone.xml");
    	Student s1=(Student)applicationContext.getBean("s1");
    	System.out.println(s1.getStdId()+" "+s1.getStdName());
    	Student s2=(Student)applicationContext.getBean("s2");
    	System.out.println(s2.getStdId()+" "+s2.getStdName());
    	
    }
}
