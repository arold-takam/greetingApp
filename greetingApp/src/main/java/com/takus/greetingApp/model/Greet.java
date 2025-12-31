package com.takus.greetingApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "greet")
public class Greet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	public Greet() {
	}
	
	public Greet(String message) {
		this.message = message;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
