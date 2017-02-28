package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * Spring 由构造函数自动装配
 * 这种模式与 byType 非常相似，但它应用于构造器参数。
 * Spring 容器看作 beans，在 XML 配置文件中 beans 的 autowire 属性设置为 constructor。
 * 然后，它尝试把它的构造函数的参数与配置文件中 beans 名称中的一个进行匹配和连线。
 * 如果找到匹配项，它会注入这些 bean，否则，它会抛出异常。
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
