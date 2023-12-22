package data.utils.mapping;

import domain.model.users.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User toUser(ResultSet resultSet) throws SQLException {
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
