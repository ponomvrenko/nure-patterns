package data.dao.impl;

import data.dao.TrainersDao;
import domain.model.users.User;
import data.utils.DBConnector;
import data.utils.DBService;
import data.utils.mapping.UserMapper;
import data.utils.tables.TrainersTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlTrainersDaoImpl implements TrainersDao {

    private final DBConnector dbConnector;

    public MySqlTrainersDaoImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public Integer getNumberOfClients(int trainerId) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareCall(TrainersTable.GET_NUMBER_OF_CLIENTS);

            statement.setInt(2, trainerId);
            resultSet = statement.executeQuery();

            Integer result = null;

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }
    }

    @Override
    public List<User> getAll(int offset, int rowCount) {
        List<User> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(TrainersTable.GET_ALL);

            statement.setInt(1, offset);
            statement.setInt(2, rowCount);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(UserMapper.toUser(resultSet));
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
    public User getById(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(TrainersTable.GET_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = UserMapper.toUser(resultSet);
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
    public List<User> getByNameAndSurnameOrLogin(String name, String surname, String login, int offset, int rowCount) {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(TrainersTable.GET_BY_NAME_AND_SURNAME_OR_LOGIN);

            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, login);
            statement.setInt(4, offset);
            statement.setInt(5, rowCount);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(UserMapper.toUser(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return users;
    }

    @Override
    public User getTrainerByClientId(int id) {
        User trainer = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            statement = connection.prepareStatement(TrainersTable.GET_TRAINER_BY_CLIENT_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                trainer = UserMapper.toUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeResultSet(resultSet);
            DBService.closeStatement(statement);
            DBService.closeConnection(connection);
        }

        return trainer;
    }

    @Override
    public User getByEmail(String email) {
        // Implementation not provided in the original Kotlin code
        throw new UnsupportedOperationException("Not implemented yet");
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
            statement = connection.prepareStatement(TrainersTable.SAVE);

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
            statement = connection.prepareStatement(TrainersTable.UPDATE);

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
            statement = connection.prepareStatement(TrainersTable.DELETE);
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