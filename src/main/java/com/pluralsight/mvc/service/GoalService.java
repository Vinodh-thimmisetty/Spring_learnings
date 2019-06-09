package com.pluralsight.mvc.service;

import java.util.List;

import com.pluralsight.mvc.model.Goal;
import com.pluralsight.mvc.model.GoalReport;

public interface GoalService {
	
	Goal saveGoal(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> goalReports();

}
