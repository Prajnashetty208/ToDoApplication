package com.todo.restapp.service.impl;

import com.todo.restapp.exception.DuplicateItemException;
import com.todo.restapp.exception.ItemNotFoundException;
import com.todo.restapp.model.ToDoList;
import com.todo.restapp.repository.ToDoRepo;
import com.todo.restapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Value("${entries}")
    private int maxEntries;

    @Autowired
    private ToDoRepo repo;

    @Override
    public String save(ToDoList obj){
        if(repo.findById(obj.getName()).isPresent()) throw new DuplicateItemException("Item already present in database");
        if(repo.findByDate(LocalDate.now()) > maxEntries-1) throw new DuplicateItemException("List full for the day");
        obj.setDate(LocalDate.now());
        repo.save(obj);
        return "Saved successfully";
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
