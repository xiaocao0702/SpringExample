package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注入 Bean 的依赖性
 * 
 * 当 @Beans 依赖对方时，表达这种依赖性非常简单，只要有一个 bean 方法调用另一个
 * 
 * @author caopl
 *
 */
@Configuration
public class AppConfig {
	@Bean
	public Foo foo() {
		return new Foo(bar());
	}
	
	@Bean
	public Bar bar() {
		return new Bar();
	}
}

class Foo {
	private Bar bar;
	public Foo(Bar bar) {
		this.bar = bar;
	}
	public Bar getBar() {
		return bar;
	}
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	public void print() {
		System.out.println("foo print...");
	}
}

class Bar {
	public Bar() {
		System.out.println("bar init...");
	}
}
