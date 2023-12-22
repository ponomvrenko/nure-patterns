package java.data.utils.tables;

import org.intellij.lang.annotations.Language;

public class ClientsTable {

    @Language("sql")
    public static final String GET_BY_ID = "select * from client where id = ?";

    @Language("sql")
    public static final String GET_BY_TRAINER_ID = "select * from client where trainer_id = ? order by id limit ?, ?";

    @Language("sql")
    public static final String GET_BY_LOGIN = "select * from client where login = ?";

    @Language("sql")
    public static final String SAVE = "insert into client (c_name, surname, login, c_password, phone_number, email) values (?, ?, ?, ?, ?, ?)";

    @Language("sql")
    public static final String UPDATE = "update client set c_name = ?, surname = ?, login = ?, c_password = ?, phone_number = ?, email = ? where id = ?";

    @Language("sql")
    public static final String DELETE = "delete from client where id = ?";
}
