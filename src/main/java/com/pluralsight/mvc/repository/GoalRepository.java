package com.pluralsight.mvc.repository;

import java.util.List;

import com.pluralsight.mvc.model.Goal;
import com.pluralsight.mvc.model.GoalReport;

public interface GoalRepository {

	Goal saveGoal(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> goalReports();
}
