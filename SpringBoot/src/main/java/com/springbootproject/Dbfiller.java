package com.springbootproject;
import java.util.ArrayList;
import java.util.Arrays;

import com.springbootproject.entities.ToDo;
import com.springbootproject.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dbfiller implements CommandLineRunner{

    private ToDoRepository todorepository;

    @Autowired
    public Dbfiller(ToDoRepository todorepository){

        this.todorepository = todorepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        ToDo t = new ToDo("Do Stuff!", false);
        ToDo t1 = new ToDo("Do more stuff", false);
        ToDo t2 = new ToDo("... More!", false);
        ToDo t3 = new ToDo("Enough!", false);

        todorepository.saveAll(Arrays.asList(t, t1, t2, t3));

        System.out.println("ENDE!");
    }

    
}
