package com.pluralsight.mvc.service;

import java.util.List;

import com.pluralsight.mvc.model.Activity;
import com.pluralsight.mvc.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();
	Exercise saveExercise(Exercise exercise);

}