package com.springbootproject.service;
import com.springbootproject.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long idUser);
    User getUser(long idUser);
    List<User> getUserList();
}
