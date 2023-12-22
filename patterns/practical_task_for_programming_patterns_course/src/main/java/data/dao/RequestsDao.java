package data.dao;

import domain.model.users.RequestDB;

import java.util.List;

public interface RequestsDao extends BaseDao<RequestDB> {

    List<RequestDB> getByClientId(int clientId);

    List<RequestDB> getByTrainerId(int trainerId);
}
