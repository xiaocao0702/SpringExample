package com.tutorialspoint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 中的事件处理
 * Spring 的核心是 ApplicationContext，它负责管理 beans 的完整生命周期。
 * 当加载 beans 时，ApplicationContext 发布某些类型的事件。
 * 通过 ApplicationEvent 类和 ApplicationListener 接口来提供在 ApplicationContext 中处理事件。
 * 如果一个 bean 实现 ApplicationListener，那么每次 ApplicationEvent 被发布到 ApplicationContext 上，那个 bean 会被通知。
 * Spring 提供了以下的标准事件：
 * 1 ContextRefreshedEvent
 * ApplicationContext 被初始化或刷新时，该事件被发布。这也可以在 ConfigurableApplicationContext 接口中使用 refresh() 方法来发生。
 * 2 ContextStartedEvent
 * 当使用 ConfigurableApplicationContext 接口中的 start() 方法启动 ApplicationContext 时，该事件被发布。你可以调查你的数据库，或者你可以在接受到这个事件后重启任何停止的应用程序。
 * 3 ContextStoppedEvent
 * 当使用 ConfigurableApplicationContext 接口中的 stop() 方法停止 ApplicationContext 时，发布这个事件。你可以在接受到这个事件后做必要的清理的工作。
 * 4 ContextClosedEvent
 * 当使用 ConfigurableApplicationContext 接口中的 close() 方法关闭 ApplicationContext 时，该事件被发布。一个已关闭的上下文到达生命周期末端；它不能被刷新或重启。
 * 5 RequestHandledEvent
 * 这是一个 web-specific 事件，告诉所有 bean HTTP 请求已经被服务。
 * 
 * 由于 Spring 的事件处理是单线程的，所以如果一个事件被发布，直至并且除非所有的接收者得到的该消息，该进程被阻塞并且流程将不会继续。
 * 因此，如果事件处理被使用，在设计应用程序时应注意。
 *  
 * 
 * @author caopl
 * 
 */
public class MainApp {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		// Let us raise a start event.
    context.start();
    
    HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

    obj.getMessage();

    // Let us raise a stop event.
    context.stop();
		
	}
	
}
