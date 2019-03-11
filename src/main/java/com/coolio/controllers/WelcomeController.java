package com.coolio.controllers;

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

	@GetMapping("/welcomeNote")
	public String welcomeController() {
		return "Welcome to Coolio. This is my first commit with some code. So, wish me luck :)";
	}
}
