package java.data.utils.tables;

import org.intellij.lang.annotations.Language;

public class TrainersTable {

    @Language("sql")
    public static final String GET_NUMBER_OF_CLIENTS = "{?= call get_number_of_clients(?)}";

    @Language("sql")
    public static final String GET_ALL = "select * from trainer order by id limit ?, ?";

    @Language("sql")
    public static final String GET_BY_ID = "select * from trainer where id = ?";

    @Language("sql")
    public static final String GET_BY_NAME_AND_SURNAME_OR_LOGIN = "select * from trainer where t_name = ? and surname = ? or login = ? order by id limit ?, ?";

    @Language("sql")
    public static final String GET_TRAINER_BY_CLIENT_ID = "select * from trainer where id = (select trainer_id from client where id = ?)";

    @Language("sql")
    public static final String SAVE = "insert into trainer (t_name, surname, login, t_password, phone_number, email) values (?, ?, ?, ?, ?, ?)";

    @Language("sql")
    public static final String UPDATE = "update trainer set t_name = ?, surname = ?, login = ?, t_password = ?, phone_number = ?, email = ? where id = ?";

    @Language("sql")
    public static final String DELETE = "delete from trainer where id = ?";
}
