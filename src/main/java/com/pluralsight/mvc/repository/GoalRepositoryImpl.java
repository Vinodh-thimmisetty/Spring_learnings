package com.pluralsight.mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.mvc.model.Goal;
import com.pluralsight.mvc.model.GoalReport;

@Repository
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Goal saveGoal(Goal goal) {
		entityManager.persist(goal);
		entityManager.flush();
		return null;
	}

	@Override
	public List<Goal> findAllGoals() {
//		return entityManager.createQuery("select g from Goal g", Goal.class).getResultList();
		return entityManager.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class).getResultList();
	}

	@Override
	public List<GoalReport> goalReports() {
//		return entityManager.createQuery(
//				"Select new com.pluralsight.mvc.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id = e.goal.id",
//				GoalReport.class).getResultList();
		return entityManager.createNamedQuery(Goal.GOAL_REPORTS, GoalReport.class).getResultList();
	}

}
