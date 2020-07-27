package duing.service.impl;

import duing.dao.UserDao;
import duing.dao.impl.UserDaoImpl;
import duing.domain.User;
import duing.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
}
