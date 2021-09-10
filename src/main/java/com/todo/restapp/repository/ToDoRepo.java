package com.todo.restapp.repository;

import com.todo.restapp.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoList, String> {

    @Query(value = "SELECT COUNT(*) FROM todolist_table "+
            " WHERE date = :date", nativeQuery = true)
    int findByDate(LocalDate date);

    ToDoList findByStatus(String status);
}
