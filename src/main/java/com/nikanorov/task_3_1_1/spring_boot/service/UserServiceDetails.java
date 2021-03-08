package com.nikanorov.task_3_1_1.spring_boot.service;

import com.nikanorov.task_3_1_1.spring_boot.dao.UserDAO;
import com.nikanorov.task_3_1_1.spring_boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceDetails implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceDetails(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUserByName(String name) {
        return userDAO.findByUserName(name);
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", name));
        }
        return user;
    }
}
