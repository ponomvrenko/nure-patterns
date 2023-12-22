package data.dao.impl;

import data.dao.ClientsDao;
import domain.model.users.User;
import data.utils.DBConnector;
import data.utils.DBService;
import data.utils.tables.ClientsTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlClientsDaoImpl implements ClientsDao {

    private final DBConnector dbConnector;

    public MySqlClientsDaoImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public User getById(int clientId) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ClientsTable.GET_BY_ID);
            statement.setInt(1, clientId);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = toUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return user;
    }

    @Override
    public List<User> getByTrainerId(int trainerId, int offset, int rowCount) {
        List<User> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ClientsTable.GET_BY_TRAINER_ID);
            statement.setInt(1, trainerId);
            statement.setInt(2, offset);
            statement.setInt(3, rowCount);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(toUser(resultSet));
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
    public User getByLogin(String login) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ClientsTable.GET_BY_LOGIN);
            statement.setString(1, login);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = toUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return user;
    }

    @Override
    public User getByEmail(String email) {
        // TODO: Implement the method
        return null;
    }

    @Override
    public boolean create(User item) {
        if (item.getPassword() == null) {
            return false;
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ClientsTable.SAVE);
            statement.setString(1, item.getName());
            statement.setString(2, item.getSurname());
            statement.setString(3, item.getLogin());
            statement.setString(4, item.getPassword());
            statement.setString(5, item.getPhoneNumber());
            statement.setString(6, item.getEmail());

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
    public boolean update(User item) {
        if (item.getPassword() == null) {
            return false;
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ClientsTable.UPDATE);
            statement.setString(1, item.getName());
            statement.setString(2, item.getSurname());
            statement.setString(3, item.getLogin());
            statement.setString(4, item.getPassword());
            statement.setString(5, item.getPhoneNumber());
            statement.setString(6, item.getEmail());
            statement.setInt(7, item.getId());

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
    public boolean delete(User item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(ClientsTable.DELETE);
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

    private User toUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getString(7)
        );
    }
}
