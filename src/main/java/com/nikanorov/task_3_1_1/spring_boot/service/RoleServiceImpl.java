package com.nikanorov.task_3_1_1.spring_boot.service;

import com.nikanorov.task_3_1_1.spring_boot.dao.RoleDAO;
import com.nikanorov.task_3_1_1.spring_boot.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.findByRole(name);
    }

    @Override
    public Role getById(long id) {
        Role role = null;
        Optional<Role> data = roleDAO.findById(id);
        if(data.isPresent()){
            role = data.get();
        }
        return role ;
    }
}
