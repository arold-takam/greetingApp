package com.takus.greetingApp.repository;

import com.takus.greetingApp.model.Greet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetRepository extends JpaRepository<Greet, Long> {

}
