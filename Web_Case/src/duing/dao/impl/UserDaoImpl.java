package duing.dao.impl;

import duing.dao.UserDao;
import duing.domain.User;
import duing.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        template.update(sql,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?,gender = ?,age = ?," +
                "address = ?,qq = ?,email = ? where id = ?";
        template.update(sql,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail(),
                user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历Map
        //定义一个参数的集合
        List<Object> params = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        for(String key : keySet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ?");
                params.add("%"+value+"%");//加入条件的值
            }
        }

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> finByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历Map
        //定义一个参数的集合
        List<Object> params = new ArrayList<Object>();
        Set<String> keySet = condition.keySet();
        for(String key : keySet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ?");
                params.add("%"+value+"%");//加入条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}