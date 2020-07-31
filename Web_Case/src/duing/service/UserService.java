package duing.service;

import duing.domain.PageBean;
import duing.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
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
    public void deleteUser(String id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 批量删除选中的用户
     * @param ids
     */
    public void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
