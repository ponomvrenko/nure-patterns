package data.dao;

import domain.model.training.Exercise;

import java.util.List;

public interface ExercisesDao extends BaseDao<Exercise> {

    List<Exercise> getByWorkoutId(long workoutId);
}
