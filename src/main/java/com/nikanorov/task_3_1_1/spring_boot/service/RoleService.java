package com.nikanorov.task_3_1_1.spring_boot.service;



import com.nikanorov.task_3_1_1.spring_boot.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleByName(String name);
     Role getById(long id);
}
