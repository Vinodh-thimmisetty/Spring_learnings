package com.pluralsight.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Range;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = Goal.GOAL_REPORTS, query = "Select new com.pluralsight.mvc.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id = e.goal.id"),
		@NamedQuery(name = Goal.FIND_ALL_GOALS, query = "select g from Goal g")
		})
public class Goal {

	public static final String FIND_ALL_GOALS = "findAllGoals";
	public static final String GOAL_REPORTS = "findGoalReports";

	@Id
	@GeneratedValue
	private long id;
	@Range(min = 1, max = 120)
	private int minutes;

	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Exercise> exercises = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

}