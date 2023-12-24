package com.itlabs.backend.Service.Impl;

import com.itlabs.backend.Service.UserService;
import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.models.exceptions.InvalidUserCredentialsException;
import com.itlabs.backend.models.exceptions.PasswordsNotMatchingException;
import com.itlabs.backend.models.exceptions.UsernameAlreadyExistsException;
import com.itlabs.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(String email, String password, String repeatedPassword,
                         String name, String surname, String phoneNumber) throws InvalidUserCredentialsException, PasswordsNotMatchingException {

        if (email == null || email.isEmpty() || password == null || password.isEmpty() || name == null || name.isEmpty()
                || surname == null || surname.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
            throw new InvalidUserCredentialsException();
        } else if (!password.equals(repeatedPassword)) {
            throw new PasswordsNotMatchingException();
        } else if (userRepository.findByEmail(email).isPresent()) {
            throw new UsernameAlreadyExistsException();
        }
        User user = new User(name, surname, email, phoneNumber, passwordEncoder.encode(password), RoleType.USER);
        userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        if(email == null || email.isEmpty() || password == null ||password.isEmpty()){
            throw new InvalidUserCredentialsException();
        }
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new InvalidUserCredentialsException());
    }
}
