package com.takus.greetingApp.controller.impl;

import com.takus.greetingApp.model.Greet;
import com.takus.greetingApp.service.GreetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/greets")
@CrossOrigin(origins = "*")
public class GreetController implements com.takus.greetingApp.controller.GreetController {
	private final GreetService service;
	
	public GreetController(GreetService service) {
		this.service = service;
	}
//	-----------------------------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/get/default")
	@Override
	public ResponseEntity<?> defaultGreeting() {
		try {
			Greet greet=  service.defaultGreeting();
			
			return new ResponseEntity<>(greet, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path = "/change")
	@Override
	public ResponseEntity<?> changeGreeting(@RequestParam String message) {
		try {
			service.changeGreeting(message);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (IllegalArgumentException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	 @GetMapping(path = "/get/last")
	@Override
	public ResponseEntity<?> greet() {
		try {
			Greet greet = service.greet();
			
			return new ResponseEntity<>(greet, HttpStatus.OK);
		}catch (IllegalArgumentException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	 }
}
