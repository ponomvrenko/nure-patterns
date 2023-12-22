package data.factory.impl;

import data.dao.WorkoutsDao;
import data.dao.impl.MySqlWorkoutsDaoImpl;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlWorkoutsDaoFactory implements DaoFactory<WorkoutsDao> {
    @Override
    public WorkoutsDao create() {
        return new MySqlWorkoutsDaoImpl(MySqlDBConnector.getInstance());
    }
}
