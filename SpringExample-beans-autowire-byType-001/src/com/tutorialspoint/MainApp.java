package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 自动装配 ‘byType’
 * 这种模式由属性类型指定自动装配。
 * Spring 容器看作 beans，在 XML 配置文件中 beans 的 autowire 属性设置为 byType。
 * 然后，如果它的 type 恰好与配置文件中 beans 名称中的一个相匹配，它将尝试匹配和连接它的属性。
 * 如果找到匹配项，它将注入这些 beans，否则，它将抛出异常。
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
