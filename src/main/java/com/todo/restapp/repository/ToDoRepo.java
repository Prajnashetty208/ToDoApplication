package com.todo.restapp.repository;

import com.todo.restapp.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoList, String> {

    @Query(value = "SELECT * FROM todolist_table "+
            " WHERE status = :status", nativeQuery = true)
    ToDoList findByStatus(@Param("status") String status);
}
