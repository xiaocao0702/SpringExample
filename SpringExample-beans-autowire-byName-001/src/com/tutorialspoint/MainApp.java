package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Beans 自动装配
 * Spring 容器可以在不使用 和 元素的情况下自动装配相互协作的 bean 之间的关系
 * 使用<bean>元素的 autowire 属性为一个 bean 定义指定自动装配模式。
 * 自动装配模式:
 * 	no	这是默认的设置，它意味着没有自动装配，你应该使用显式的bean引用来连线。你不用为了连线做特殊的事。在依赖注入章节你已经看到这个了。
 * 	byName	由属性名自动装配。Spring 容器看到在 XML 配置文件中 bean 的自动装配的属性设置为 byName。然后尝试匹配，并且将它的属性与在配置文件中被定义为相同名称的 beans 的属性进行连接。
 * 	byType	由属性数据类型自动装配。Spring 容器看到在 XML 配置文件中 bean 的自动装配的属性设置为 byType。然后如果它的类型匹配配置文件中的一个确切的 bean 名称，它将尝试匹配和连接属性的类型。如果存在不止一个这样的 bean，则一个致命的异常将会被抛出。
 * 	constructor	类似于 byType，但该类型适用于构造函数参数类型。如果在容器中没有一个构造函数参数类型的 bean，则一个致命错误将会发生。
 * 	autodetect	Spring首先尝试通过 constructor 使用自动装配来连接，如果它不执行，Spring 尝试通过 byType 来自动装配。
 * 可以使用 byType 或者 constructor 自动装配模式来连接数组和其他类型的集合。
 * 
 * 自动装配的局限性
 * 当自动装配始终在同一个项目中使用时，它的效果最好。如果通常不使用自动装配，它可能会使开发人员混淆的使用它来连接只有一个或两个 bean 定义。不过，自动装配可以显著减少需要指定的属性或构造器参数，但你应该在使用它们之前考虑到自动装配的局限性和缺点。
 * 重写的可能性	你可以使用总是重写自动装配的 <constructor-arg>和 <property> 设置来指定依赖关系。
 * 原始数据类型	你不能自动装配所谓的简单类型包括基本类型，字符串和类。
 * 混乱的本质	自动装配不如显式装配精确，所以如果可能的话尽可能使用显式装配。
 * 
 * Spring 自动装配 ‘byName’
 * 
 * 这种模式由属性名称指定自动装配。
 * Spring 容器看作 beans，在 XML 配置文件中 beans 的 auto-wire 属性设置为 byName。
 * 然后，它尝试将它的属性与配置文件中定义为相同名称的 beans 进行匹配和连接。
 * 如果找到匹配项，它将注入这些 beans，否则，它将抛出异常。
 * 
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
