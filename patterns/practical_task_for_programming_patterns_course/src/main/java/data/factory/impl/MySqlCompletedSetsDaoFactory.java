package data.factory.impl;

import data.dao.CompletedSetsDao;
import data.dao.impl.MySqlCompletedSetsDaoImpl;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlCompletedSetsDaoFactory implements DaoFactory<CompletedSetsDao> {

    @Override
    public CompletedSetsDao create() {
        return new MySqlCompletedSetsDaoImpl(MySqlDBConnector.getInstance());
    }
}
