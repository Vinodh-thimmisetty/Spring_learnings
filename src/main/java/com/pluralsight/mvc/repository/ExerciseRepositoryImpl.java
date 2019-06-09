package com.pluralsight.mvc.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.mvc.model.Exercise;

@Repository
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Exercise saveExercise(Exercise exercise) {
		entityManager.persist(exercise);
		entityManager.flush();
		return null;
	}

}
