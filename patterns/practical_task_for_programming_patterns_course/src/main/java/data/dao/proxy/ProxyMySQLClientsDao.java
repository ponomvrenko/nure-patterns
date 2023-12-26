package data.dao.proxy;

import data.dao.ClientsDao;
import data.dao.impl.MySqlClientsDaoImpl;
import domain.model.users.User;
import java.util.List;

public class ProxyMySQLClientsDao implements ClientsDao {

    private final ClientsDao clientsDao = new MySqlClientsDaoImpl();

    private void checkUserType() throws Exception {
        Class<? extends Class> curUser = Class.class.getClass();
        if (curUser == null ||
                curUser.getTypeName().equals(User.class.getTypeName())) {
            throw new Exception(curUser.getName() + ", доступ на зміну даних заборонений!");
        }
    }


    @Override
    public boolean create(User item) {
        return clientsDao.create(item);
    }

    @Override
    public boolean update(User item) {
        return clientsDao.update(item);
    }

    @Override
    public boolean delete(User item) {
        return clientsDao.delete(item);
    }

    @Override
    public User getById(int clientId) {
        return clientsDao.getById(clientId);
    }

    @Override
    public List<User> getByTrainerId(int trainerId) {
        return clientsDao.getByTrainerId(trainerId);
    }

    @Override
    public User getByLogin(String login) {
        return clientsDao.getByLogin(login);
    }

    @Override
    public User getByEmail(String email) {
        return clientsDao.getByEmail(email);
    }
}
