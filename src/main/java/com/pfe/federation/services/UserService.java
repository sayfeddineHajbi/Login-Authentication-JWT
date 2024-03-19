package com.pfe.federation.services;


import com.pfe.federation.IService.IUserService;
import com.pfe.federation.entities.User;
import com.pfe.federation.exception.UserAlreadyExistsException;
import com.pfe.federation.exception.UserNotFoundException;
import com.pfe.federation.entities.Role;
import com.pfe.federation.repositories.RoleRepository;
import com.pfe.federation.user.UserRecord;
import com.pfe.federation.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public User add(User user) {
        Optional<User> theUser = userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(role));
        return userRepository.save(user);
    }

    @Override
    public List<UserRecord> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserRecord(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                       new HashSet<>(user.getRoles()))).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }


    }


