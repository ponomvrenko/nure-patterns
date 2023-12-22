package data.dao.impl;

import data.dao.ExercisesDao;
import domain.model.training.Exercise;
import data.utils.DBConnector;
import data.utils.DBService;
import data.utils.mapping.TimeUtil;
import data.utils.tables.ExerciseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlExercisesDaoImpl implements ExercisesDao {

    private final DBConnector dbConnector;

    public MySqlExercisesDaoImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Exercise> getByWorkoutId(long workoutId) {
        List<Exercise> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ExerciseTable.GET_BY_WORKOUT_ID);
            statement.setLong(1, workoutId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(toExercise(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return result;
    }

    @Override
    public boolean create(Exercise item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ExerciseTable.SAVE);
            statement.setString(1, item.getName());
            statement.setByte(2, item.getSets());
            statement.setShort(3, item.getRepetitionsFrom());
            statement.setShort(4, item.getRepetitionsTo());
            statement.setShort(5, item.getWeightFrom() != null ? item.getWeightFrom() : 0);
            statement.setShort(6, item.getWeightTo() != null ? item.getWeightTo() : 0);
            statement.setTime(7, item.getTime() != null ? TimeUtil.toSql(item.getTime()) : null);
            statement.setString(8, item.getNotes());
            statement.setLong(9, item.getWorkoutId());

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return false;
    }

    @Override
    public boolean update(Exercise item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ExerciseTable.UPDATE);
            statement.setString(1, item.getName());
            statement.setByte(2, item.getSets());
            statement.setShort(3, item.getRepetitionsFrom());
            statement.setShort(4, item.getRepetitionsTo());
            statement.setShort(5, item.getWeightFrom() != null ? item.getWeightFrom() : 0);
            statement.setShort(6, item.getWeightTo() != null ? item.getWeightTo() : 0);
            statement.setTime(7, item.getTime() != null ? TimeUtil.toSql(item.getTime()) : null);
            statement.setString(8, item.getNotes());
            statement.setLong(9, item.getId());

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return false;
    }

    @Override
    public boolean delete(Exercise item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ExerciseTable.DELETE);
            statement.setLong(1, item.getId());

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return false;
    }

    private Exercise toExercise(ResultSet resultSet) throws SQLException {
        return new Exercise(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getByte(3),
                resultSet.getShort(4),
                resultSet.getShort(5),
                resultSet.getShort(6),
                resultSet.getShort(7),
                resultSet.getTime(8) != null ? TimeUtil.fromSql(resultSet.getTime(8)) : null,
                resultSet.getString(9),
                null,  // Assuming completedSets is not loaded in this operation
                resultSet.getLong(10)
        );
    }
}