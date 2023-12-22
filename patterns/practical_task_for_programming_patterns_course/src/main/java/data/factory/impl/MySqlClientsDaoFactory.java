package data.factory.impl;

import data.dao.ClientsDao;
import data.dao.impl.MySqlClientsDaoImpl;
import data.factory.DaoFactory;
import data.utils.MySqlDBConnector;

public class MySqlClientsDaoFactory implements DaoFactory<ClientsDao> {
    @Override
    public ClientsDao create() {
        return new MySqlClientsDaoImpl(MySqlDBConnector.getInstance());
    }
}
