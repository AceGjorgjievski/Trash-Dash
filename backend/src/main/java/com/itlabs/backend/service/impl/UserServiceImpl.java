package com.itlabs.backend.Service.Impl;

import com.itlabs.backend.Service.UserService;
import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.models.exceptions.InvalidUserCredentialsException;
import com.itlabs.backend.models.exceptions.PasswordsNotMatchingException;
import com.itlabs.backend.models.exceptions.UsernameAlreadyExistsException;
import com.itlabs.backend.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepository.
                findByEmail(username).
                orElseThrow(() -> new UsernameNotFoundException(username));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                u.getEmail(),
                u.getPassword(),
                Stream.of(new SimpleGrantedAuthority(u.getRole().toString())).collect(Collectors.toList()));
        return userDetails;
    }
}
