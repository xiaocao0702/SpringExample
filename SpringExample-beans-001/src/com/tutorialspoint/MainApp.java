package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 的作用域
 * 
 * @author caopl
 *
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.setMessage("I'm object A");
		obj.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		objB.getMessage();
	}
}
