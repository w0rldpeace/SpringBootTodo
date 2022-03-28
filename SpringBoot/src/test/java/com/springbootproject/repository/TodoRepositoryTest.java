package com.springbootproject.repository;

//import static org.junit.jupiter.api.Assertions.;
import com.springbootproject.entities.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class TodoRepositoryTest {

    Todo t, t1, t2, t3;
    @Autowired
    private TodoRepository todoRepository;

    @BeforeEach
    private void todoRepositoryPopulator(){

        t = new Todo("Test1", false);
        t1 = new Todo("Test2", false);
        t2 = new Todo("Test3", true);
        t3 = new Todo("Another Test!", false);

        todoRepository.saveAll(Arrays.asList(t, t1, t2, t3));
    }
    @Test
    public void givenTodoRepository_whenSaveAndRetrieveEntity_thenOK(){
        Todo todoEntity = todoRepository.save(new Todo("test", false));
        //Was geht hier ab? Wieso "Optional"
        Todo foundEntity = todoRepository.findById(todoEntity.getId()).orElse(null);

        assertNotNull(foundEntity);
        assertEquals(todoEntity, foundEntity);
    }

    @Test
    public void findDoneTodos(){
        assertEquals(1, todoRepository.findByDoneTrue().size());

    }
    @Test
    public void findOpenTodos(){
        assertEquals(3, todoRepository.findByDoneFalse().size());
    }
}
