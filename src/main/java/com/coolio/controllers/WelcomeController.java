package com.coolio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * This is the end point to get basic non sensitive information about the
 * application
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WelcomeController {
	
	@Value("${coolio.welcometext}")
	private String welcomeNote;
	
	@Value("${coolio.info.json}")
	private String coolioInfo;

	public String index() {
		return "index";
	}
	
	// To check if the microservice is live.
	@GetMapping("/all/lub")
	public Mono<String> lubDub() {
		Mono<String> dub = Mono.just("dub");
		return dub;
	}
	
	@GetMapping("/all/welcomeNote")
	public String welcomeController() {
		return welcomeNote;
	}
	
	@GetMapping("/protected/gimmeAppInfo")
	public String gimmeAppInfo() {
		return coolioInfo;
	}
		
}
