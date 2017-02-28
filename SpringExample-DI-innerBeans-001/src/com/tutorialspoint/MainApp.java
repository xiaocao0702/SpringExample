package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 注入内部 Beans
 * 正如你所知道的 Java 内部类是在其他类的范围内被定义的，同理，inner beans 是在其他 bean 的范围内定义的 bean。因此在 或 元素内 元素被称为内部bean
 * 
 * <bean id="outerBean" class="...">
 * 	<property name="target">
 *  	<bean id="innerBean" class="..."/>
 *	</property>
 * </bean>
 * 
 * @author caopl
 *
 */
public class MainApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
	}
	
}
