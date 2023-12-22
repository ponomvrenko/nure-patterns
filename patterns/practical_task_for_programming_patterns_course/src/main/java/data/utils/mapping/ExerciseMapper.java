package data.utils.mapping;

import domain.model.training.Exercise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseMapper {

    public static Exercise mapResultSetToExercise(ResultSet resultSet) throws SQLException {
        Exercise exercise = new Exercise();

        exercise.setId(resultSet.getLong(1));
        exercise.setName(resultSet.getString(2));
        exercise.setSets(resultSet.getByte(3));
        exercise.setRepetitionsFrom(resultSet.getShort(4));
        exercise.setRepetitionsTo(resultSet.getShort(5));
        exercise.setWeightFrom(resultSet.getShort(6));
        exercise.setWeightTo(resultSet.getShort(7));
        exercise.setTime(resultSet.getTime(8) != null ? TimeUtil.fromSql(resultSet.getTime(8)) : null);
        exercise.setNotes(resultSet.getString(9));
        exercise.setWorkoutId(resultSet.getLong(10));

        return exercise;
    }

    public static List<Exercise> mapResultSetToExerciseList(ResultSet resultSet) throws SQLException {
        List<Exercise> exerciseList = new ArrayList<>();
        while (resultSet.next()) {
            exerciseList.add(mapResultSetToExercise(resultSet));
        }
        return exerciseList;
    }
}
