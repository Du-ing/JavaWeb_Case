package duing.service;

import duing.domain.PageBean;
import duing.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    public void addUser(User user);

    public void deleteUser(String id);

    public User findUserById(String id);

    public void updateUser(User user);

    public void delSelectedUser(String[] ids);

    public PageBean<User> findUserByPage(String currentPage, String rows);
}
