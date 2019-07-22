package com.coolio.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CoolioPasswordEncoder {

	public static void main(String[] args) {
		String adminPassword = "aseempassword";
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println("Admin Password: " + bCryptPasswordEncoder.encode(adminPassword));
		
		String userPassword = "usersaviorocks";
		System.out.println("User Password: " + bCryptPasswordEncoder.encode(userPassword));
	}
	
}
