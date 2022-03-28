package com.springbootproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="TODO_TASK", length=100, nullable=false, unique=false)
    private String description;

    @Column(name="DONE", nullable = false)
    private Boolean done = false;

    public Long getId() {
        return id;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Todo(String description, Boolean done){
        this.description = description;
        this.done = done;
    }

    public Todo() {
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
