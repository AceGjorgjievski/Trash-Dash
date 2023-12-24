package com.itlabs.backend.models;

import com.itlabs.backend.models.enums.RoleType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Report> reports;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User() {
    }

    public User(String name, String surname, String email, String phoneNumber, String password, RoleType role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}
