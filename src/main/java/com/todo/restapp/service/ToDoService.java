package com.todo.restapp.service;

import com.todo.restapp.model.ToDoList;

import java.util.Set;

public interface ToDoService {
    String save(ToDoList obj);
    Set<ToDoList> findAll();
    ToDoList findByName(String id);
    String updateItem(ToDoList obj);
    String deleteItem(String id);

}
