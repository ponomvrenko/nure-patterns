package data.utils.mapping;

import domain.model.training.Workout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class WorkoutMapper {

    /*public static Workout toWorkout(ResultSet resultSet) throws SQLException {
        return new Workout(
                resultSet.getString(2),
                resultSet.getDate(3),
                resultSet.getInt(4)
        )
                .setId(resultSet.getLong(1))
                .build();
    }*/

    public static java.sql.Date toSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
