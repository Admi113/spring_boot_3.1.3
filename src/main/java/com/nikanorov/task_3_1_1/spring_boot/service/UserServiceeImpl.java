package com.nikanorov.task_3_1_1.spring_boot.service;

import com.nikanorov.task_3_1_1.spring_boot.dao.UserRepository;
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


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceeImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }


    @Override
    public void save(User user) {

        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));

        userRepository.save(user);
    }


    @Override
    public void update(User user, int id) {

//        User userOld = getById(id);
//        String oldPass = userOld.getPassword();
//        String newPass = user.getPassword();
//        if (!passwordEncoder.matches(newPass, oldPass)) {
//            userOld.setPassword(passwordEncoder.encode(newPass));
//        }
//
//        userDAO.sa  (user, id);


//        User userOld = findById(id);
        User userOld = null;
        Optional<User> userOlds = userRepository.findById(id);

        if (userOlds.isPresent()) {
            userOld = userOlds.get();
        }

        userOld.setName(user.getName());
        userOld.setSurname(user.getSurname());
        userOld.setAge(user.getAge());
        userOld.setRoles(user.getRoles());


        userRepository.save(userOld);
    }


    @Override
    public User getById(int id) {
        User user = null;
        Optional<User> data = userRepository.findById(id);
        if (data.isPresent()) {
            user = data.get();
        }
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
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
