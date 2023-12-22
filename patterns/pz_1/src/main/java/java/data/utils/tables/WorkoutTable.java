package java.data.utils.tables;

import org.intellij.lang.annotations.Language;

public class WorkoutTable {

    @Language("sql")
    public static final String GET_BY_CLIENT_ID = "select * from workout where client_id = ? order by w_date desc limit ?, ?";

    @Language("sql")
    public static final String SAVE = "insert into workout (w_type, w_date, client_id) values (?, ?, ?)";

    @Language("sql")
    public static final String UPDATE = "update workout set w_type = ?, w_date = ? where id = ?";

    @Language("sql")
    public static final String DELETE = "delete from workout where id = ?";
}
