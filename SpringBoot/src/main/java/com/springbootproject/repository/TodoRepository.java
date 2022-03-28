package com.springbootproject.repository;

import com.springbootproject.entities.Todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{

    List<Todo> findByDoneTrue();
    List<Todo> findByDoneFalse();

}