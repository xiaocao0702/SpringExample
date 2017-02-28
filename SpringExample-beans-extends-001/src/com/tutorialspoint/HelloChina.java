package com.tutorialspoint;

public class HelloChina {
	private String message1;
	private String message2;
	private String message3;

	public void getMessage1() {
		System.out.println("Child Message : " + message1);
	}

	public void setMessage1(String message) {
		this.message1 = message;
	}
	
	public void getMessage2() {
		System.out.println("Child Message : " + message2);
	}
	
	public void setMessage2(String message) {
		this.message2 = message;
	}
	
	public void getMessage3() {
		System.out.println("Child Message : " + message3);
	}
	
	public void setMessage3(String message) {
		this.message3 = message;
	}
	
	public void init() {
		System.out.println("Bean child is going through init...");
	}
	
	public void destroy() {
		System.out.println("Bean child will destroy now...");
	}
	
}
