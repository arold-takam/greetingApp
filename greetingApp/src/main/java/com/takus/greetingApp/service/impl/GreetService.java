package com.takus.greetingApp.service.impl;

import com.takus.greetingApp.model.Greet;
import com.takus.greetingApp.repository.GreetRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetService implements com.takus.greetingApp.service.GreetService {
	private final GreetRepository repository;
	
	public GreetService(GreetRepository repository) {
		this.repository = repository;
	}
	
//	--------------------------------------------------------------------------------
	
	@Override
	public Greet defaultGreeting() {
		Greet greet = new Greet();
		greet.setMessage("HELLO WORLD !");
		
		return greet;
	}
	
	@Override
	public void changeGreeting(String message) {
		if (message.isBlank()){
			throw new IllegalArgumentException("Wrong or empty message; try again.");
		}
		
		Greet greet = new Greet();
		greet.setMessage(message);
		
		repository.save(greet);
	}
	
	@Override
	public Greet greet() {
		Greet greet = repository.findAll().getLast();
		if (greet == null){
			throw new IllegalArgumentException("No greet found.");
		}
		
		return greet;
	}
}
