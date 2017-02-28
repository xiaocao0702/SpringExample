package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * @Autowired 的（required=false）选项
 * 默认情况下，@Autowired 注释意味着依赖是必须的，它类似于 @Required 注释，
 * 然而，你可以使用 @Autowired 的 （required=false） 选项关闭默认行为。
 * 
 * @author caopl
 *
 */
public class Student2 {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	
	@Autowired(required=false)
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	
	
}
