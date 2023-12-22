package java.data.utils.tables;

import org.intellij.lang.annotations.Language;

public class CompletedSetsTable {

    @Language("sql")
    public static final String GET_BY_EXERCISE_ID = "select * from completed_sets where exercise_id = ?";

    @Language("sql")
    public static final String SAVE = "insert into completed_sets (set_number, repetitions, weight, c_time, notes, exercise_id) values (?, ?, ?, ?, ?, ?)";

    @Language("sql")
    public static final String UPDATE = "update completed_sets set set_number = ?, repetitions = ?, weight = ?, c_time = ?, notes = ? where id = ?";

    @Language("sql")
    public static final String DELETE = "delete from completed_sets where id = ?";
}
