package com.nikanorov.task_3_1_1.spring_boot.dao;

//import com.mysql.cj.xdevapi.SessionFactory;


import com.nikanorov.task_3_1_1.spring_boot.models.User;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


@Repository

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByName(String name);

}
