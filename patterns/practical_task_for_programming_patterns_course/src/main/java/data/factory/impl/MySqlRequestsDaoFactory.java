package data.factory.impl;

import data.dao.RequestsDao;
import data.dao.impl.MySqlRequestsDaoImpl;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlRequestsDaoFactory implements DaoFactory<RequestsDao> {

    @Override
    public RequestsDao create() {
        return new MySqlRequestsDaoImpl(MySqlDBConnector.getInstance());
    }
}