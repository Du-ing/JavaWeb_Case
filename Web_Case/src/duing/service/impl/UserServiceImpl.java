package duing.service.impl;

import duing.dao.UserDao;
import duing.dao.impl.UserDaoImpl;
import duing.domain.User;
import duing.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
