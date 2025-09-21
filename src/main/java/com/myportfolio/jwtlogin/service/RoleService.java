package com.myportfolio.jwtlogin.service;

import com.myportfolio.jwtlogin.dao.RoleDao;
import com.myportfolio.jwtlogin.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
