package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 中基于 AOP 的 @AspectJ
 * @AspectJ 作为通过 Java 5 注释注释的普通的 Java 类，它指的是声明 aspects 的一种风格。
 * 通过在你的基于架构的 XML 配置文件中包含以下元素，@AspectJ 支持是可用的。
 * <aop:aspectj-autoproxy/>
 * 声明一个 aspect
 * @Aspect
 * public class AspectModule {
 * }
 * 声明一个切入点
 * 一个切入点有助于确定使用不同建议执行的感兴趣的连接点（即方法）。在处理基于配置的 XML 架构时，切入点的声明有两个部分：
 * 一个切入点表达式决定了我们感兴趣的哪个方法会真正被执行。
 * 一个切入点标签包含一个名称和任意数量的参数。方法的真正内容是不相干的，并且实际上它应该是空的。
 * @Pointcut("execution(* com.xyz.myapp.service.*.*(..))") // expression 
 * private void businessService() {}  // signature
 * 声明建议
 * 你可以使用 @{ADVICE-NAME} 注释声明五个建议中的任意一个，如下所示。这假设你已经定义了一个切入点标签方法 businessService()：
 *  @Before("businessService()")
 *  public void doBeforeTask(){ ... }
 *  @AfterReturning(pointcut = "businessService()", returning="retVal")
 *  public void doAfterReturnningTask(Object retVal){ ... }
 *  
 *  你可以为任意一个建议定义你的切入点内联。下面是在建议之前定义内联切入点的一个示例：
 *  @Before("execution(* com.xyz.myapp.service.*.*(..))")
 *  public doBeforeTask(){ ... }
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
