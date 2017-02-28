package com.tutorialspoint;

public class HelloWorld {
	private String message1;
	private String message2;

	public void getMessage1() {
		System.out.println("Parent Message : " + message1);
	}

	public void setMessage1(String message) {
		this.message1 = message;
	}
	
	public void getMessage2() {
		System.out.println("Parent Message : " + message2);
	}
	
	public void setMessage2(String message) {
		this.message2 = message;
	}
	
	public void init() {
		System.out.println("Bean parent is going through init...");
	}
	
	public void destroy() {
		System.out.println("Bean parent destroy now...");
	}
	
}
