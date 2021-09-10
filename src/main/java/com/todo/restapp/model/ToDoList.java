package com.todo.restapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "todolist_table")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {

    @Id
    @Column(name="name")
    private String name;

    @Column(name="status")
    private String status;

    @Column(name="progress")
    private String progress;

    @Column(name="date")
    private Date date;

}
