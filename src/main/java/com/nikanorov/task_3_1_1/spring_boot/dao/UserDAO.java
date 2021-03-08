package com.nikanorov.task_3_1_1.spring_boot.dao;

//import com.mysql.cj.xdevapi.SessionFactory;


import com.nikanorov.task_3_1_1.spring_boot.models.User;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


@Repository

public interface UserDAO extends JpaRepository<User, Integer> {


    @PersistenceContext
    EntityManager em ;



//    default User getUserByName(String name) {
//        Query q = em.createQuery("from User where name =: name");
//        q.setParameter("name", name);
//        return (User) q.getSingleResult();
//    }
        public User findByUserName(String username);


    default void update(User user, int id) {
        User userOld = null;
        Optional<User> userOlds = findById(id);

        if (userOlds.isPresent()) {
            userOld = userOlds.get();
        }


        userOld.setName(user.getName());
        userOld.setSurname(user.getSurname());
        userOld.setAge(user.getAge());
        userOld.setRoles(user.getRoles());


        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(userOld);
    }

//
//    void delete(int id);
//
//    User getById(int id);
//
//    List<User> getAllUsers();
//
//
//    void save(User user);
//
//


}
