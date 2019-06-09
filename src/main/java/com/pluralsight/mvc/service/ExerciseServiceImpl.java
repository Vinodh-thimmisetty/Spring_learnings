package com.pluralsight.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.mvc.model.Activity;
import com.pluralsight.mvc.model.Exercise;
import com.pluralsight.mvc.repository.ExerciseRepository;

@Service("exerciseService")
@Transactional
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;

	public List<Activity> findAllActivities() {

		List<Activity> activities = new ArrayList<Activity>();

		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);

		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);

		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);

		return activities;
	}

	@Override
	public Exercise saveExercise(Exercise exercise) {
		return exerciseRepository.saveExercise(exercise);
	}

}