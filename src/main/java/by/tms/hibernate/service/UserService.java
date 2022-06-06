package by.tms.hibernate.service;

import by.tms.hibernate.dao.UserDao;
import by.tms.hibernate.entity.User;
import java.util.List;

public class UserService {

    private final UserDao usersDao = new UserDao();

    public UserService() {  }

    public void save(User user) {
        usersDao.saveFromDB(user);
    }

    public void update(User user) {
        usersDao.updateFromDB(user);
    }

    public void delete(User user) {
        usersDao.deleteFromDB(user);
    }

    public User findById(int id) {
        return usersDao.findByIdFromDB(id);
    }

    public List<User> findAll() {
        return usersDao.findAllFromDB();
    }

}
