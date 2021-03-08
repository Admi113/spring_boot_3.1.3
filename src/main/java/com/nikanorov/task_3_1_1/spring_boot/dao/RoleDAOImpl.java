//package com.nikanorov.task_3_1_1.spring_boot.dao;
//
//import com.nikanorov.task_3_1_1.spring_boot.models.Role;
//import org.springframework.stereotype.Repository;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class RoleDAOImpl implements RoleDAO{
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<Role> getAllRoles() {
//        Query q = em.createQuery("from Role e", Role.class);
//        return q.getResultList();
//    }
//
//    @Override
//    public Role getRoleByName(String name) {
////        Query q = em.createQuery("from User where name =: name", User.class);
//            Query q = em.createQuery("from Role where name =: name");
//            q.setParameter("name",name);
//            return (Role) q.getSingleResult();
//        }
//
//    @Override
//    public Role getById(long id) {
//        return em.find(Role.class, id);
//    }
//}
