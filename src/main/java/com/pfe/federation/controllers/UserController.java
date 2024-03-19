package com.pfe.federation.controllers;

import com.pfe.federation.entities.User;
import com.pfe.federation.exception.UserNotFoundException;
import com.pfe.federation.jwt.JWTAuthenticationRequest;
import com.pfe.federation.jwt.JWTService;
import com.pfe.federation.services.UserService;
import com.pfe.federation.user.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/all")

    public ResponseEntity<List<UserRecord>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }
    @PostMapping("/login")
    public String getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
            throw new UserNotFoundException("Invalid user credentials");
        }

    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable("email") String email){
        return  userService.getUser(email);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        userService.delete(email);
    }



}
