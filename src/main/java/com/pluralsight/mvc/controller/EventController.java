package com.pluralsight.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.mvc.model.Event;

@Controller
//@SessionAttributes("event")
public class EventController {

	@GetMapping("/event")
	public String getEvent(Model model) {
		Event e = new Event();
		e.setName("Java user group");

		model.addAttribute("event", e);
		return "event";
	}

	@PostMapping("/event")
	public String postEvent(@ModelAttribute Event event, HttpServletRequest request) {
		System.out.println(">>> Event posted :: " + event);
//		return "redirect:"+request.getContextPath();
		return  "forward:forwarded";
	}
	
	@PostMapping("/forwarded")
	public String forwarded(HttpServletRequest request) {
		System.out.println(">>> Event forwarded as part of session :: " + request.getSession().getAttribute("event"));
		return "test";
	}
}
