package com.pluralsight.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pluralsight.mvc.model.Attende;

@Controller
public class AttendeController {

	@GetMapping("/attende")
	public ModelAndView attende(Model model) {
		Attende attende = new Attende();
		model.addAttribute("attende", attende);
		return new ModelAndView("attende");
	}

	@PostMapping("/attende")
	public String postAttende(@Valid Attende attende, BindingResult bindingResult, Model m) {
		System.out.println("Attende :: " + attende);

		if (bindingResult.hasErrors()) {
			return "attende";
		}

		return "forward:forwarded";
	}
}
