package com.todo.restapp.service.impl;

import com.todo.restapp.model.ToDoList;
import com.todo.restapp.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ToDoServiceImpl implements ToDoService {
    @Override
    public String save(ToDoList obj) {
        return null;
    }

    @Override
    public Set<ToDoList> findAll() {
        return null;
    }

    @Override
    public ToDoList findByName(String id) {
        return null;
    }

    @Override
    public String updateItem(ToDoList obj) {
        return null;
    }

    @Override
    public String deleteItem(String id) {
        return null;
    }
}
