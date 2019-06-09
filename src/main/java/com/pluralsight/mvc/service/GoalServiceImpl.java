package com.pluralsight.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.mvc.model.Goal;
import com.pluralsight.mvc.model.GoalReport;
import com.pluralsight.mvc.repository.GoalRepository;

@Service
@Transactional
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;

	@Override
	public Goal saveGoal(Goal goal) {
		return goalRepository.saveGoal(goal);
	}

	@Override
	public List<Goal> findAllGoals() {
		return goalRepository.findAllGoals();
	}

	@Override
	public List<GoalReport> goalReports() {
		return goalRepository.goalReports();
	}

}
