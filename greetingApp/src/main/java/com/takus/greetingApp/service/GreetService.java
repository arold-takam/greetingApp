package com.takus.greetingApp.service;

import com.takus.greetingApp.model.Greet;

public interface GreetService {
	
	Greet defaultGreeting();
	
	void changeGreeting(String message);
	
	Greet greet();
}
