package com.todo.restapp.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="roles_table",schema = "todoschema")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;
}
