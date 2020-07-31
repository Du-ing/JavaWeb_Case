package duing.dao;

import duing.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     *根据条件查找记录数
     * @param condition
     * @return
     */
    public int findTotalCount(Map<String, String[]> condition);

    /**
     * 根据条查找数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    public List<User> finByPage(int start, int rows, Map<String, String[]> condition);
}
