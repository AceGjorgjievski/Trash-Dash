package com.itlabs.backend.Service;

import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.models.exceptions.InvalidUserCredentialsException;
import com.itlabs.backend.models.exceptions.PasswordsNotMatchingException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    void register(String email, String password, String repeatedPassword, String name, String surname, String phoneNumber) throws InvalidUserCredentialsException, PasswordsNotMatchingException;
    User login(String email, String password);
    User findUserByEmail(String email);
}
