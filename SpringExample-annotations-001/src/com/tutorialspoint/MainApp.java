package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 基于注解的配置
 * 1	@Required
 * @Required 注解应用于 bean 属性的 setter 方法。
 * 它表明受影响的 bean 属性在配置时必须放在 XML 配置文件中，否则容器就会抛出一个 BeanInitializationException 异常。
 * 2	@Autowired
 * @Autowired 注释对在哪里和如何完成自动连接提供了更多的细微的控制。
 * @Autowired 注解可以应用到 bean 属性的 setter 方法，非 setter 方法，构造函数和属性。
 * Setter 方法中的 @Autowired
 * 你可以在 XML 文件中的 setter 方法中使用 @Autowired 注释来除去 元素。
 * 当 Spring遇到一个在 setter 方法中使用的 @Autowired 注释，它会在方法中视图执行 byType 自动连接。
 * 
 * 3	@Qualifier
 * 通过指定确切的将被连线的 bean，@Autowired 和 @Qualifier 注解可以用来删除混乱。
 * 4	JSR-250 Annotations
 * Spring 支持 JSR-250 的基础的注解，其中包括了 @Resource，@PostConstruct 和 @PreDestroy 注解。
 * 
 * 
 * 
 * 
 * @author caopl
 * 你可以在属性中使用 @Autowired 注释来除去 setter 方法。
 * 当时使用 为自动连接属性传递的时候，Spring 会将这些传递过来的值或者引用自动分配给那些属性。
 */
public class MainApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		// @Required
		Student student = (Student) context.getBean("student");
		System.out.println("Name : " + student.getName());
		System.out.println("Age : " + student.getAge());
		
		// @Required
		Student2 student2 = (Student2) context.getBean("student2");
		System.out.println("Name2 : " + student2.getName());
		System.out.println("Age2 : " + student2.getAge());
		
		// Setter方法中的 @Autowired 
		TextEditor te = (TextEditor) context.getBean("textEditor");
    te.spellCheck();
 
    // 属性中的@Autowired 
    TextEditor2 te2 = (TextEditor2) context.getBean("textEditor2");
    te2.spellCheck();
    
    // 构造函数中的 @Autowired
    TextEditor3 te3 = (TextEditor3) context.getBean("textEditor3");
    te3.spellCheck();
    
    // Spring @Qualifier 注释
    Profile profile = (Profile)context.getBean("profile");
    profile.printName();
    profile.printAge();
    
    // @PostConstruct 和 @PreDestroy 注释：
    HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    obj.getMessage();
    context.registerShutdownHook();

    // @Resource 注释：
    TextEditor4 te4 = (TextEditor4) context.getBean("textEditor4");
    te4.spellCheck();
	}
	
}
