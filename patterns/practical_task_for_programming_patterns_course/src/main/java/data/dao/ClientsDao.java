package data.dao;

import domain.model.users.User;

import java.util.List;

public interface ClientsDao extends BaseDao<User> {

    User getById(int clientId);

    List<User> getByTrainerId(int trainerId, int offset, int rowCount);

    User getByLogin(String login);

    User getByEmail(String email);
}
