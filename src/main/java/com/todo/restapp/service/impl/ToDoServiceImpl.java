package com.todo.restapp.service.impl;

import com.todo.restapp.exception.DuplicateItemException;
import com.todo.restapp.exception.ItemNotFoundException;
import com.todo.restapp.model.ToDoList;
import com.todo.restapp.repository.ToDoRepo;
import com.todo.restapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepo repo;

    @Override
    public String save(ToDoList obj){
        if(repo.findById(obj.getName()).isPresent()) this.throwException();
        obj.setDate(LocalDate.now());
        repo.save(obj);
        return "Saved successfully";
    }

    private Consumer<? super ToDoList> throwException() {
        throw new DuplicateItemException("Item already present in database");
    }

    @Override
    public List<ToDoList> findAll() {
        return this.repo.findAll();
    }

    @Override
    public ToDoList findByName(String id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Details not found"));
    }

    @Override
    public ToDoList findByStatus(String status) {
        return this.repo.findByStatus(status);
    }

    @Override
    public String updateItem(ToDoList obj) {
        return repo.findById(obj.getName())
                .map(item -> {
                    item.setProgress(obj.getProgress());
                    item.setStatus(obj.getStatus());
                    item.setDate(LocalDate.now());
                    repo.save(item);
                    return "Updated successfully";
                })
                .orElseThrow(() -> new ItemNotFoundException("Details not found"));
    }

    @Override
    public String deleteItem(String id) {
        repo.deleteById(id);
        return "Deleted successfully";
    }
}
