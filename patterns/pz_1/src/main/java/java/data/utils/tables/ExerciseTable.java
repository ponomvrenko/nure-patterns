package java.data.utils.tables;

import org.intellij.lang.annotations.Language;

public class ExerciseTable {

    @Language("sql")
    public static final String GET_BY_WORKOUT_ID = "select * from exercise where workout_id = ?";

    @Language("sql")
    public static final String SAVE = "insert into exercise (e_name, sets, repetitions_from, repetitions_to, weight_from, weight_to, e_time, notes, workout_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Language("sql")
    public static final String UPDATE = "update exercise set e_name = ?, sets = ?, repetitions_from = ?, repetitions_to = ?, weight_from = ?, weight_to = ?, e_time = ?, notes = ? where id = ?";

    @Language("sql")
    public static final String DELETE = "delete from exercise where id = ?";
}
