package duing.service.impl;

import duing.dao.AdminDao;
import duing.dao.impl.AdminDaoImpl;
import duing.domain.Admin;
import duing.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public boolean registAdmin(Admin admin) {
        return adminDao.registAdmin(admin.getUsername(),admin.getPassoword());
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        return adminDao.findAdminByUsernameAndPassword(admin.getUsername(),admin.getPassoword());
    }
}
