package java.data.dao;

import java.domain.model.training.Workout;
import java.util.List;

public interface WorkoutsDao extends BaseDao<Workout> {

    List<Workout> getByClientId(int clientId, int offset, int rowCount);
}
