package duing.service.impl;

import duing.dao.UserDao;
import duing.dao.impl.UserDaoImpl;
import duing.domain.PageBean;
import duing.domain.User;
import duing.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
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

    @Override
    public void delSelectedUser(String[] ids) {
        //遍历id数组
        for(String id:ids){
            //调用Dao
            userDao.deleteUser(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用Dao查询所有记录数
        int totalCount = userDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //调用Dao查询List
        int start = (currentPage - 1) * rows;//开始的记录索引
        List<User> list = userDao.finByPage(start,rows);
        pb.setList(list);
        //计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
