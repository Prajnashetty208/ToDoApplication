package com.todo.restapp.controller;

import com.todo.restapp.model.ToDoList;
import com.todo.restapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/todo/")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<String> saveToDoList(@RequestBody ToDoList request){
        return new ResponseEntity<String>(service.save(request), HttpStatus.OK);
    }

    @GetMapping(value = "/getList",produces = "application/json")
    public ResponseEntity<Set<ToDoList>> getToDoList(){
        return new ResponseEntity<Set<ToDoList>>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getItemByName/{name}",produces = "application/json")
    public ResponseEntity<ToDoList> getItemByName(@PathVariable("id") String name){
        return new ResponseEntity<ToDoList>(service.findByName(name), HttpStatus.OK);
    }

    @PutMapping (value = "/updateItem", consumes = "application/json")
    public ResponseEntity<String> updateItem(@RequestBody ToDoList request){
       return new ResponseEntity<String>(service.updateItem(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteItemByName/{name}",produces = "application/json")
    public ResponseEntity<String>  deleteItemByName(@PathVariable("id") String name){
        return new ResponseEntity<String>(service.deleteItem(name), HttpStatus.OK);
    }
}
