package duing.service;

import duing.domain.Admin;

public interface AdminService {
    public boolean registAdmin(Admin admin);
    public Admin loginAdmin(Admin admin);
}
