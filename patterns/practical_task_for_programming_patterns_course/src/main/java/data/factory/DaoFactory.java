package data.factory;

import data.dao.BaseDao;

public interface DaoFactory<T extends BaseDao<?>> {
    T create();
}
