package data.dao.impl;

import data.dao.WorkoutsDao;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlWorkoutsDaoFactory implements DaoFactory<WorkoutsDao> {

    @Override
    public WorkoutsDao create() {
        return new MySqlWorkoutsDaoImpl(MySqlDBConnector.getInstance());
    }
}