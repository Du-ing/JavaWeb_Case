package duing.dao;

import duing.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();

    public void addUser(User user);

    public void deleteUser(int id);

    public User findUserById(int id);

    public void updateUser(User user);

    public int findTotalCount();

    public List<User> finByPage(int start, int rows);
}
