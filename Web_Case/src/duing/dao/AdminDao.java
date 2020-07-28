package duing.dao;

import duing.domain.Admin;

public interface AdminDao {
    public boolean registAdmin(String username,String password);
    public Admin findAdminByUsernameAndPassword(String username,String password);
}
