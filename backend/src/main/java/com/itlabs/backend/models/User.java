package com.itlabs.backend.models;

import com.itlabs.backend.models.enums.RoleType;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String phoneNumber;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Report> reports;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User() {
    }

    public User(String name, String surname, String phoneNumber, String password, RoleType role) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}
