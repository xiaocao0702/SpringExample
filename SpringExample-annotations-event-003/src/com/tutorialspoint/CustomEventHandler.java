package com.tutorialspoint;

import org.springframework.context.ApplicationListener;

/**
 * 
 * @author caopl
 *
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println("CustomEvent Received!" + event.toString());
	}

}
