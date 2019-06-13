package com.pluralsight.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginHome(Model model) {
		log.info("<== Loading Sigin page ==>");
		return "login";
	}

	@GetMapping("/loginFailed")
	public String loginFailed(Model model) {
		log.info("<== failed Sigin page ==>");
		model.addAttribute("error", true);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		log.info("<== logout ==>");
		return "logout";
	}
	
	@GetMapping("/errro403")
	public String errro403() {
		return "errors/403";
	}

}
