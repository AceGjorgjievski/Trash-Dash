package com.itlabs.backend.service;

import com.itlabs.backend.models.enums.RoleType;

public interface UserService {
    void register(String email, String password, String repeatedPassword, String name, String surname, String phoneNumber);
}
