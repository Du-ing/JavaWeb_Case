package duing.dao.impl;

import duing.dao.AdminDao;
import duing.domain.Admin;
import duing.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean registAdmin(String username,String password) {
        //查找注册名是否重复
        String findSql = "select * from admin where username = ?";
        Admin flag = new Admin();
        try {
            flag = template.queryForObject(findSql,new BeanPropertyRowMapper<Admin>(Admin.class),username);
        } catch (DataAccessException e) {
            flag = null;
        }
        if(flag == null){
            //没有重复
            String sql = "insert into admin values(null,?,?)";
            template.update(sql,username,password);
            return true;
        }else {
            //重复
            return false;
        }
    }

    @Override
    public Admin findAdminByUsernameAndPassword(String username, String password) {
        String sql = "select * from admin where username = ? and password = ?";
        Admin admin = new Admin();
        try {
            admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), username, password);
        } catch (DataAccessException e) {
            admin = null;
        }
        return admin;
    }
}
