package com.todo.restapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "todolist_table",schema = "todoschema")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {

    @Id
    @Column(name="name")
    @Length(min=5,max=25,message = "Invalid length of the field 'name'")
    @Pattern(regexp = "^[a-zA-Z][0-9a-zA-Z]*"
            ,message = "Field 'name' should be alphanumeric and start with a character ")
    private String name;

    @Column(name="status")
    private String status;

    @Column(name="progress")
    private String progress;

    @Column(name="date")
    private LocalDate date;

}
