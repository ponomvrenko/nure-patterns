package data.factory.impl;

import data.dao.TrainersDao;
import data.dao.impl.MySqlTrainersDaoImpl;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlTrainersDaoFactory implements DaoFactory<TrainersDao> {

    @Override
    public TrainersDao create() {
        return new MySqlTrainersDaoImpl(MySqlDBConnector.getInstance());
    }
}