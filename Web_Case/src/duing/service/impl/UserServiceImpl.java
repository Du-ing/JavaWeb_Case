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
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
