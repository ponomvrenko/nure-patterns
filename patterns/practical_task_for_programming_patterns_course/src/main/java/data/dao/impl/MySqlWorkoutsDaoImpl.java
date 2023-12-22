package data.dao.impl;

import data.dao.WorkoutsDao;
import data.utils.DBConnector;
import data.utils.DBService;
import data.utils.mapping.WorkoutMapper;
import data.utils.tables.WorkoutTable;
import domain.model.training.Workout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlWorkoutsDaoImpl implements WorkoutsDao {

    private final DBConnector dbConnector;

    public MySqlWorkoutsDaoImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Workout> getByClientId(int clientId, int offset, int rowCount) {
        List<Workout> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(WorkoutTable.GET_BY_CLIENT_ID);

            statement.setInt(1, clientId);
            statement.setInt(2, offset);
            statement.setInt(3, rowCount);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(WorkoutMapper.toWorkout(resultSet));
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
    public boolean create(Workout item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(WorkoutTable.SAVE);

            statement.setString(1, String.valueOf(item));
            statement.setDate(2, new java.sql.Date(item.getDate().getTime()));
            statement.setInt(3, item.getClientId());

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
    public boolean update(Workout item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(WorkoutTable.UPDATE);

            statement.setString(1, item.getType());
            statement.setDate(2, new java.sql.Date(item.getDate().getTime()));
            statement.setLong(3, item.getId());

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
    public boolean delete(Workout item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(WorkoutTable.DELETE);
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
}