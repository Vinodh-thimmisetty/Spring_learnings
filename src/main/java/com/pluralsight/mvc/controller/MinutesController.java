package com.pluralsight.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.mvc.model.Activity;
import com.pluralsight.mvc.model.Exercise;
import com.pluralsight.mvc.service.ExerciseService;

@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;

	@GetMapping(value = "/addMinutes")
	public String getMinutes(@ModelAttribute("exercise") Exercise exercise) {

		return "addMinutes";
	}

	@PostMapping(value = "/addMinutes")
	public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result) {

		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());

		if (result.hasErrors()) {
			return "addMinutes";
		}

		return "addMinutes";
	}

	@GetMapping(value = "/activities")
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}

}