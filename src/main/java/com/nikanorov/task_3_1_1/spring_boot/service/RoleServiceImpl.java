package com.nikanorov.task_3_1_1.spring_boot.service;

import com.nikanorov.task_3_1_1.spring_boot.dao.RoleRepository;
import com.nikanorov.task_3_1_1.spring_boot.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    @Autowired
    public void setRoleDAO(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByRole(name);
    }

    @Override
    public Role getById(long id) {
        Role role = null;
        Optional<Role> data = roleRepository.findById(id);
        if(data.isPresent()){
            role = data.get();
        }
        return role ;
    }
}
