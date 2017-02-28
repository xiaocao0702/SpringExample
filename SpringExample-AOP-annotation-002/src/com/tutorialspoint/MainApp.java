package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 中基于 AOP 的 XML架构
 * 为了在本节的描述中使用 aop 命名空间标签，你需要导入 spring-aop j架构，如下所述：
 * <?xml version="1.0" encoding="UTF-8"?>
 * <beans xmlns="http://www.springframework.org/schema/beans"
 *     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
 *     xmlns:aop="http://www.springframework.org/schema/aop"
 *     xsi:schemaLocation="http://www.springframework.org/schema/beans
 *     http://www.springframework.org/schema/beans/spring-beans-3.0.xsd 
 *     http://www.springframework.org/schema/aop 
 *     http://www.springframework.org/schema/aop/spring-aop-3.0.xsd ">
 *     
 *    <!-- bean definition & AOP specific configuration -->
 * </beans>
 * 
 * 你还需要在你的应用程序的 CLASSPATH 中使用以下 AspectJ 库文件。这些库文件在一个 AspectJ 装置的 ‘lib’ 目录中是可用的，否则你可以在 Internet 中下载它们。
 * aspectjrt.jar
 * aspectjweaver.jar
 * aspectj.jar
 * aopalliance.jar
 * 
 * 声明一个 aspect
 * 一个 aspect 是使用 元素声明的，支持的 bean 是使用 ref 属性引用的
 * <aop:config>
 *    <aop:aspect id="myAspect" ref="aBean">
 *    ...
 *    </aop:aspect>
 * </aop:config>
 * <bean id="aBean" class="...">...</bean>
 * 
 * 声明一个切入点
 * 一个切入点有助于确定使用不同建议执行的感兴趣的连接点（即方法）。在处理基于配置的 XML 架构时，切入点将会按照如下所示定义：
 * <aop:config>
 *    <aop:aspect id="myAspect" ref="aBean">
 *    <aop:pointcut id="businessService" expression="execution(* com.xyz.myapp.service.*.*(..))"/>
 *    ...
 *    </aop:aspect>
 * </aop:config>
 * <bean id="aBean" class="...">...</bean>
 * 声明建议
 * 你可以使用 <aop:{ADVICE NAME}> 元素在一个 中声明五个建议中的任何一个
 * <aop:config>
 *    <aop:aspect id="myAspect" ref="aBean">
 *       <aop:pointcut id="businessService" expression="execution(* com.xyz.myapp.service.*.*(..))"/>
 *       <!-- a before advice definition -->
 *       <aop:before pointcut-ref="businessService" method="doRequiredTask"/>
 *       <!-- an after advice definition -->
 *       <aop:after pointcut-ref="businessService" method="doRequiredTask"/>
 *       <!-- an after-returning advice definition -->
 *       <!--The doRequiredTask method must have parameter named retVal -->
 *       <aop:after-returning pointcut-ref="businessService" 
 *       		returning="retVal" 
 *       		method="doRequiredTask"/>
 *       <!-- an after-throwing advice definition -->
 *       <!--The doRequiredTask method must have parameter named ex -->
 *       <aop:after-throwing pointcut-ref="businessService"
 *          throwing="ex"
 *          method="doRequiredTask"/>
 *       <!-- an around advice definition -->
 *       <aop:around pointcut-ref="businessService" method="doRequiredTask"/>
 *    	 ...
 *    </aop:aspect>
 * </aop:config>
 * <bean id="aBean" class="...">...</bean>
 * 你可以对不同的建议使用相同的 doRequiredTask 或者不同的方法。这些方法将会作为 aspect 模块的一部分来定义。
 * 
 * 
 * @author caopl
 * 
 */
public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Student student = (Student)context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();
		
	}
	
}
