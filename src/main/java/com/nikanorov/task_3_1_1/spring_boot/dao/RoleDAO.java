package com.nikanorov.task_3_1_1.spring_boot.dao;


import com.nikanorov.task_3_1_1.spring_boot.models.Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface RoleDAO extends JpaRepositoryImplementation<Role,Long> {
//    List<Role> getAllRoles();

    Role getRoleByName(String name);

//    Role getById(long id);
}
