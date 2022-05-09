package com.springbootproject.service;

import com.springbootproject.entities.Todo;
import com.springbootproject.entities.User;
import com.springbootproject.repository.TodoRepository;
import com.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public List<User> getUserList() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public User getUser(long idUser) {
        return userRepository.findById(idUser).orElseThrow(
                () -> new EntityNotFoundException(messageSource.getMessage("notFoundError", null, LocaleContextHolder.getLocale()))
        );
    }
}
