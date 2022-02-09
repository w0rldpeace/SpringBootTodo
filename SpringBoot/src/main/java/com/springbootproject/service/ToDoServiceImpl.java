package com.springbootproject.service;

import com.springbootproject.beans.TodoBean;
import com.springbootproject.dto.CreateTaskDto;
import com.springbootproject.dto.UpdateTaskDto;
import com.springbootproject.entities.ToDo;
import com.springbootproject.repository.ToDoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ToDo create(CreateTaskDto todo) {

        ToDo t = modelMapper.map(todo, ToDo.class);
        return toDoRepository.save(t);
    }

    @Override
    public ToDo read(Long id) {

        return toDoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Bruh!")
        );
    }

    @Override
    public ToDo update(UpdateTaskDto newTask) {

        ToDo old = toDoRepository.findById(newTask.getId()).orElseThrow();
        modelMapper.map(newTask, old);

        return toDoRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        toDoRepository.deleteAll();
    }

    @Override
    public List<ToDo> readAllDone() {

        return toDoRepository.findByDoneTrue();
    }

    @Override
    public List<ToDo> readAllTodo() {

        return toDoRepository.findByDoneFalse();
    }

    @Override
    public Long countDone() {

        return toDoRepository.countByDone(true);
    }

    @Override
    public Long countTodo() {
        return toDoRepository.countByDone(false);
    }
}
