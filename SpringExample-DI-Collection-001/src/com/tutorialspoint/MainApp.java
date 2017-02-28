package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 注入集合
 * Spring 提供了四种类型的集合的配置元素
 * <list>	它有助于连线，如注入一列值，允许重复。
 * <set>	它有助于连线一组值，但不能重复。
 * <map>	它可以用来注入名称-值对的集合，其中名称和值可以是任何类型。
 * <props>	它可以用来注入名称-值对的集合，其中名称和值都是字符串类型。
 * 你可以使用<list>或<set>来连接任何 java.util.Collection 的实现或数组。
 * 
 * 
 * 
 * @author caopl
 *
 */
public class MainApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	}
	
}
