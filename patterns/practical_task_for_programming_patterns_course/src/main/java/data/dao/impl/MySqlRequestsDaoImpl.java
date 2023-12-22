package data.dao.impl;

import data.dao.RequestsDao;
import domain.model.users.RequestDB;
import domain.model.users.RequestStatus;
import data.utils.DBConnector;
import data.utils.DBService;
import data.utils.mapping.RequestMapper;
import data.utils.tables.RequestTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlRequestsDaoImpl implements RequestsDao {

    private final DBConnector dbConnector;

    public MySqlRequestsDaoImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<RequestDB> getByClientId(int clientId) {
        List<RequestDB> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(RequestTable.GET_BY_CLIENT_ID);
            statement.setInt(1, clientId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(RequestMapper.toRequestDB(resultSet));
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
    public List<RequestDB> getByTrainerId(int trainerId) {
        List<RequestDB> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(RequestTable.GET_BY_TRAINER_ID);
            statement.setInt(1, trainerId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(RequestMapper.toRequestDB(resultSet));
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
    public boolean create(RequestDB item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(RequestTable.SAVE);

            statement.setInt(1, item.getTrainerId());
            statement.setInt(2, item.getClientId());
            statement.setString(3, item.getStatus().toString());

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
    public boolean update(RequestDB item) {
        Connection connection = null;
        PreparedStatement updateStatement = null;
        PreparedStatement deleteStatement = null;

        try {
            connection = dbConnector.getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            updateStatement = connection.prepareStatement(RequestTable.UPDATE);
            deleteStatement = connection.prepareStatement(RequestTable.DELETE_BY_CLIENT_ID);

            updateStatement.setString(1, item.getStatus().toString());
            updateStatement.setInt(2, item.getId());

            deleteStatement.setInt(1, item.getClientId());

            int updateResult = updateStatement.executeUpdate();

            if (item.getStatus() == RequestStatus.CONFIRMED) {
                int deleteResult = deleteStatement.executeUpdate();

                if (updateResult == 1 && deleteResult >= 1) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            }

            if (updateResult == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeStatement(updateStatement);
            DBService.closeStatement(deleteStatement);
            DBService.closeConnection(connection);
        }

        return false;
    }

    @Override
    public boolean delete(RequestDB item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(RequestTable.DELETE);
            statement.setInt(1, item.getId());

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