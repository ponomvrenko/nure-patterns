package data.utils.mapping;

import domain.model.training.CompletedSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompletedSetMapper {

    public static CompletedSet mapResultSetToCompletedSet(ResultSet resultSet) throws SQLException {
        CompletedSet completedSet = new CompletedSet();

        completedSet.setId(resultSet.getLong(1));
        completedSet.setSetNumber(resultSet.getByte(2));
        completedSet.setRepetitions(resultSet.getShort(3));
        completedSet.setWeight(resultSet.getShort(4) != 0 ? resultSet.getShort(4) : null);
        completedSet.setTime(resultSet.getTime(5) != null ? TimeUtil.fromSql(resultSet.getTime(5)) : null);
        completedSet.setNotes(resultSet.getString(6));
        completedSet.setExerciseId(resultSet.getLong(7));

        return completedSet;
    }
}
