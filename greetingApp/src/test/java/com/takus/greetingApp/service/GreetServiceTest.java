package com.takus.greetingApp.service;

import com.takus.greetingApp.model.Greet;
import com.takus.greetingApp.repository.GreetRepository;
import com.takus.greetingApp.service.impl.GreetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
// Utilise l'assertion standard de JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
public class GreetServiceTest {
	
	@Test
	void testDefaultGreeting(){
		// Mocking du repository
		GreetRepository repository = Mockito.mock(GreetRepository.class);
		GreetService service = new GreetService(repository);
		
		// Exécution
		Greet result = service.defaultGreeting();
		
		// Vérification rigoureuse
		assertEquals("HELLO WORLD !", result.getMessage(), "Le message par défaut doit être HELLO WORLD !");
	}
}