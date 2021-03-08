package com.nikanorov.task_3_1_1.spring_boot.service;


import com.nikanorov.task_3_1_1.spring_boot.models.User;

import java.util.List;

public interface UserServicee {
    User getUserByName(String name);

    void delete(int id);
    void save(User user);
    void update(User user,int id);
    User getById(int id);
    List<User> getAllUsers();

}
