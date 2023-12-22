package data.dao.impl;

import data.dao.CompletedSetsDao;
import domain.model.training.CompletedSet;
import data.utils.DBConnector;
import data.utils.DBService;
import data.utils.mapping.TimeUtil;
import data.utils.tables.CompletedSetsTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCompletedSetsDaoImpl implements CompletedSetsDao {

    private final DBConnector dbConnector;

    public MySqlCompletedSetsDaoImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<CompletedSet> getByExerciseId(long exerciseId) {
        List<CompletedSet> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(CompletedSetsTable.GET_BY_EXERCISE_ID);
            statement.setLong(1, exerciseId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(toCompletedSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return result;
    }

    @Override
    public boolean create(CompletedSet item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(CompletedSetsTable.SAVE);
            statement.setByte(1, item.getSetNumber());
            statement.setShort(2, item.getRepetitions());
            statement.setShort(3, item.getWeight() != null ? item.getWeight() : 0);
            statement.setTime(4, item.getTime() != null ? TimeUtil.toSql(item.getTime()) : null);
            statement.setString(5, item.getNotes());
            statement.setLong(6, item.getExerciseId());

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
    public boolean update(CompletedSet item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(CompletedSetsTable.UPDATE);
            statement.setByte(1, item.getSetNumber());
            statement.setShort(2, item.getRepetitions());
            statement.setShort(3, item.getWeight() != null ? item.getWeight() : 0);
            statement.setTime(4, item.getTime() != null ? TimeUtil.toSql(item.getTime()) : null);
            statement.setString(5, item.getNotes());
            statement.setLong(6, item.getId());

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
    public boolean delete(CompletedSet item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(CompletedSetsTable.DELETE);
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

    private CompletedSet toCompletedSet(ResultSet resultSet) throws SQLException {
        return new CompletedSet(
                resultSet.getLong(1),
                resultSet.getByte(2),
                resultSet.getShort(3),
                resultSet.getShort(4),
                resultSet.getTime(5) != null ? TimeUtil.fromSql(resultSet.getTime(5)) : null,
                resultSet.getString(6),
                resultSet.getLong(7)
        );
    }
}
