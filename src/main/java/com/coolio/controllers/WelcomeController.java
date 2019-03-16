package com.coolio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the end point to get basic non sensitive information about the
 * application
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@RestController
public class WelcomeController {
	
	@Value("${coolio.welcometext}")
	private String welcomeNote;
	
	@Value("${coolio.info.json}")
	private String coolioInfo;

	@GetMapping("/welcomeNote")
	public String welcomeController() {
		return welcomeNote;
	}
	
	@GetMapping("/gimmeAppInfo")
	public String gimmeAppInfo() {
		return coolioInfo;
	}
}
