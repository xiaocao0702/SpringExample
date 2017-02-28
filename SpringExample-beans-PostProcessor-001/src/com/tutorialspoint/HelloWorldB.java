package com.tutorialspoint;

public class HelloWorldB {
	private String message;

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("Bean B is going through init...");
	}
	
	public void destroy() {
		System.out.println("Bean B will destroy now...");
	}
	
}
