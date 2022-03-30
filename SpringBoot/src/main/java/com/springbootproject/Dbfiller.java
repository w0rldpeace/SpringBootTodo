package com.springbootproject;
import java.util.ArrayList;
import java.util.Arrays;

import com.springbootproject.entities.Todo;
import com.springbootproject.entities.User;
import com.springbootproject.repository.TodoRepository;

import com.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Dbfiller implements CommandLineRunner{

    private final TodoRepository todorepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String userPw = "password";
    private final String adminPw = "admin";
    private final String analystPw = "analyst";

    @Autowired
    public Dbfiller(TodoRepository todorepository, UserRepository userRepository, PasswordEncoder passwordEncoder){

        this.userRepository = userRepository;
        this.todorepository = todorepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Todo t = new Todo("Do Stuff!", false);
        Todo t1 = new Todo("Do more stuff", false);
        Todo t2 = new Todo("... More!", false);
        Todo t3 = new Todo("Enough!", false);

        todorepository.saveAll(Arrays.asList(t, t1, t2, t3));
        User user = new User("user", passwordEncoder.encode(userPw), Arrays.asList("ROLE_USER"));
        User admin = new User("admin", passwordEncoder.encode(adminPw), Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        User analyst = new User("analyst", passwordEncoder.encode(analystPw), Arrays.asList("ROLE_ANALYST", "ROLE_USER"));

        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(analyst);

        System.out.println("ENDE!");
    }

    
}
