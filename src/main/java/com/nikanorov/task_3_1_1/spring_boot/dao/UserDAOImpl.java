package com.nikanorov.task_3_1_1.spring_boot.dao;


import com.nikanorov.task_3_1_1.spring_boot.models.User;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//@Repository
@Transactional


public class UserDAOImpl extends SimpleJpaRepository<User,Integer> implements UserDAO {

    @PersistenceContext
    private EntityManager em;

//    @Override
//    public void save(User u) {
//        em.persist(u);
//    }
//
//    @Override
//    public User findByUserName(String username) {
//        return null;
//    }


    @Override
    public void update(User user, int id) {
        User userOld = findById(id);
        userOld.setName(user.getName());
        userOld.setSurname(user.getSurname());
        userOld.setAge(user.getAge());
        userOld.setRoles(user.getRoles());


        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(userOld);
    }

//
//    @Override
//    public User getUserByName(String name) {
////        Query q = em.createQuery("from User where name =: name", User.class);
//        Query q = em.createQuery("from User where name =: name");
//        q.setParameter("name", name);
//        return (User) q.getSingleResult();
//    }
//
//    @Override
//    public void delete(int id) {
//        User user = getById(id);
//        em.remove(user);
//    }
//
//    @Override
//    public User getById(int id) {
//        return em.find(User.class, id);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        Query q = em.createQuery("from User e", User.class);
//        return q.getResultList();
//    }
//

}







