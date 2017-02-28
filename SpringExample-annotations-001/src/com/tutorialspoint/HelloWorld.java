package com.tutorialspoint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct 和 @PreDestroy 注释：
 * 为了定义一个 bean 的安装和卸载，我们使用 init-method 和/或 destroy-method 参数简单的声明一下 。
 * init-method 属性指定了一个方法，该方法在 bean 的实例化阶段会立即被调用。
 * 同样地，destroy-method 指定了一个方法，该方法只在一个 bean 从容器中删除之前被调用。
 * 你可以使用 
 * @PostConstruct 注释作为初始化回调函数的一个替代
 * @PreDestroy 注释作为销毁回调函数的一个替代
 * 
 * @author caopl
 *
 */
public class HelloWorld {
	
	private String message;
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		System.out.println("Your Message : " + message);
		return message;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Bean is going through init.");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
}
