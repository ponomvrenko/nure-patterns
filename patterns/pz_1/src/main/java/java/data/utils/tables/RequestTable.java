package java.data.utils.tables;

import org.intellij.lang.annotations.Language;

public class RequestTable {

    @Language("sql")
    public static final String GET_BY_CLIENT_ID = "select * from request where client_id = ?";

    @Language("sql")
    public static final String GET_BY_TRAINER_ID = "select * from request where trainer_id = ?";

    @Language("sql")
    public static final String SAVE = "insert into request (trainer_id, client_id, r_status) values (?, ?, ?)";

    @Language("sql")
    public static final String UPDATE = "update request set r_status = ? where id = ?";

    @Language("sql")
    public static final String DELETE = "delete from request where id = ?";

    @Language("sql")
    public static final String DELETE_BY_CLIENT_ID = "delete from request where client_id = ?";
}
