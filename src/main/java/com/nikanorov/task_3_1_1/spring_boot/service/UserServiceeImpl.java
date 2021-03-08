package com.nikanorov.task_3_1_1.spring_boot.service;

import com.nikanorov.task_3_1_1.spring_boot.dao.UserDAO;
import com.nikanorov.task_3_1_1.spring_boot.models.Role;
import com.nikanorov.task_3_1_1.spring_boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceeImpl implements UserServicee, UserDetailsService {


    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceeImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void delete(int id) {
        userDAO.deleteById(id);
    }


    @Override
    public void save(User user) {
        userDAO.save(user);
    }


    @Override
    public void update(User user, int id) {

        User userOld = getById(id);
        String oldPass = userOld.getPassword();
        String newPass = user.getPassword();
        if (!passwordEncoder.matches(newPass, oldPass)) {
            userOld.setPassword(passwordEncoder.encode(newPass));
        }

        userDAO.  (user, id);
    }


    @Override
    public User getById(int id) {
        User user = null;
        Optional<User> data = userDAO.findById(id);
        if(data.isPresent()){
            user = data.get();
        }
        return user ;
    }


    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
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
