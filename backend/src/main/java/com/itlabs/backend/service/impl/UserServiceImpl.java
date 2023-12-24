package com.itlabs.backend.service.impl;

import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.repository.UserRepository;
import com.itlabs.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String email, String password, String repeatedPassword, String name, String surname, String phoneNumber) {
        return;
    }
        /*if(email == null || email.isEmpty() || password == null ||password.isEmpty() || name == null || name.isEmpty()
                    || surname == null || surname.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()){
            return "Invalid credentials";
        }else if(password.equals(repeatedPassword)) {
            return "Password does not match";
        }else if(userRepository.findByEmail(email).isPresent()){
            throw new UsernameAlreadyExistsException(email);
        }
        User user = new User(name, surname, email, phoneNumber, password, RoleType.USER);
        userRepository.save(user);*/
}
