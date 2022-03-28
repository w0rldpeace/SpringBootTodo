package com.springbootproject;
import java.util.Arrays;

import com.springbootproject.entities.Todo;
import com.springbootproject.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dbfiller implements CommandLineRunner{

    private TodoRepository todorepository;

    @Autowired
    public Dbfiller(TodoRepository todorepository){

        this.todorepository = todorepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Todo t = new Todo("Do Stuff!", false);
        Todo t1 = new Todo("Do more stuff", false);
        Todo t2 = new Todo("... More!", false);
        Todo t3 = new Todo("Enough!", false);

        todorepository.saveAll(Arrays.asList(t, t1, t2, t3));

        System.out.println("ENDE!");
    }

    
}
