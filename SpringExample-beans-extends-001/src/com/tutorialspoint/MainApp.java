package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 定义继承
 * 
 * bean 定义可以包含很多的配置信息，包括构造函数的参数，属性值，容器的具体信息例如初始化方法，静态工厂方法名，等等。
 * 子 bean 的定义继承父定义的配置数据。子定义可以根据需要重写一些值，或者添加其他值。
 * Spring Bean 定义的继承与 Java 类的继承无关，但是继承的概念是一样的。你可以定义一个父 bean 的定义作为模板和其他子 bean 就可以从父 bean 中继承所需的配置。
 * 当你使用基于 XML 的配置元数据时，通过使用父属性，指定父 bean 作为该属性的值来表明子 bean 的定义。
 * 
 * 
 * @author caopl
 *
 */
public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage1();
		obj.getMessage2();
		
		HelloChina objB = (HelloChina) context.getBean("helloChina");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();
	}
}
