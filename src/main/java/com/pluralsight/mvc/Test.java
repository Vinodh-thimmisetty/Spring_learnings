package com.pluralsight.mvc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("test");
		System.out.println(hashedPassword);
		// $2a$10$gSn.YBJ4BssD9mYBi4.4gesIqvLZO6oIpyCBHXpIeCfUoE9oIw5pu
	}
}
