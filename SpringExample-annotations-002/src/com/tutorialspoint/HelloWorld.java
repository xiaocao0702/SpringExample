package com.tutorialspoint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 
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
	
}
