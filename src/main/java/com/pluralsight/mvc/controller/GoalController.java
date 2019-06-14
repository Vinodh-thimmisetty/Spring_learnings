package com.pluralsight.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.mvc.model.Goal;
import com.pluralsight.mvc.model.GoalReport;
import com.pluralsight.mvc.service.GoalService;

@Controller
@SessionAttributes("goal")
public class GoalController {
	
	@Autowired
	private GoalService goalService;

	@GetMapping("addGoal")
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		return "addGoal";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(#goal, 'createGoal')")
	@PostMapping("addGoal")
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result,
			HttpServletRequest request) {

		System.out.println("result has errors: " + result.hasErrors());

		System.out.println("Goal set: " + goal.getMinutes());

		if (result.hasErrors()) {
			return "addGoal";
		}

		goalService.saveGoal(goal);

		return "redirect:/";
	}
	
	@GetMapping("/getGoals")
	public String getGoals(Model model) {
		List<Goal> goals = goalService.findAllGoals();
		model.addAttribute("goals", goals);
		return "getGoals";
	}
	
	@GetMapping("/getGoalReports")
	public String getGoalReports(Model model) {
		List<GoalReport> goalReports = goalService.goalReports();
		model.addAttribute("goalReports", goalReports);
		return "getGoalReports";
	}

}