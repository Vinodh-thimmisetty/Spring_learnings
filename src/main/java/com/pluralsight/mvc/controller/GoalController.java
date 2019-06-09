package com.pluralsight.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.mvc.model.Goal;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@GetMapping("addGoal")
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		return "addGoal";
	}

	@PostMapping("addGoal")
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result,
			HttpServletRequest request) {

		System.out.println("result has errors: " + result.hasErrors());

		System.out.println("Goal set: " + goal.getMinutes());

		if (result.hasErrors()) {
			return "addGoal";
		}

		return "redirect:/";
	}

}