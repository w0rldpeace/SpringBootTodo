package com.springbootproject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import com.springbootproject.entities.Todo;
import com.springbootproject.entities.User;
import com.springbootproject.repository.TodoRepository;

import com.springbootproject.repository.UserRepository;
import com.springbootproject.security.Role;
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
        User user = new User("user", passwordEncoder.encode(userPw), Set.of(Role.USER));
        User admin = new User("admin", passwordEncoder.encode(adminPw), Set.of(Role.ADMIN, Role.USER, Role.ANALYST));
        User analyst = new User("analyst", passwordEncoder.encode(analystPw), Set.of(Role.ANALYST));

        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(analyst);

        System.out.println("ENDE!");
    }

    
}
