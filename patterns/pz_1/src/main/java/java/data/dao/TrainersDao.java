package java.data.dao;

import java.domain.model.users.User;
import java.util.List;

public interface TrainersDao extends BaseDao<User> {

    Integer getNumberOfClients(int trainerId);

    List<User> getAll(int offset, int rowCount);

    User getById(int id);

    List<User> getByNameAndSurnameOrLogin(String name, String surname, String login, int offset, int rowCount);

    User getTrainerByClientId(int id);

    User getByEmail(String email);
}
