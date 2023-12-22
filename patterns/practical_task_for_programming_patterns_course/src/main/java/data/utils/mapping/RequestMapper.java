package data.utils.mapping;

import domain.model.users.Request;
import domain.model.users.RequestDB;
import domain.model.users.RequestStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper {

    public static RequestDB toRequestDB(ResultSet resultSet) throws SQLException {
        return new RequestDB(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                RequestStatus.valueOf(resultSet.getString(4).toUpperCase())
        );
    }

    public static RequestDB toRequestDB(Request request) {
        return new RequestDB(
                request.getId(),
                request.getTrainer().getId(),
                request.getClient().getId(),
                request.getStatus()
        );
    }
}