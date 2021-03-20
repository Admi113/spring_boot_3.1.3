package com.nikanorov.task_3_1_1.spring_boot.service;

import com.nikanorov.task_3_1_1.spring_boot.dao.UserRepository;
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

    private UserRepository userRepository;

    @Autowired
    public UserServiceDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = getUserByName(name);
             return user;
    }
}
