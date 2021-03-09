package com.nikanorov.task_3_1_1.spring_boot.dao;


import com.nikanorov.task_3_1_1.spring_boot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {


    Role findByRole(String name);


}
