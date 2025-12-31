package com.takus.greetingApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface GreetController {
	
	ResponseEntity<?> defaultGreeting();
	
	ResponseEntity<?> changeGreeting(@RequestParam String message);
	
	ResponseEntity<?> greet();
}
