package com.example.authmodule.controllers;

import com.example.authmodule.models.User;
import com.example.authmodule.repository.UserRepository;
import com.example.authmodule.security.payload.request.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.io.Console;
import java.util.Optional;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user){

        Optional<User> userOp = userRepository.findById(user.getId());
        User userFound = userOp.get();

        if(userFound == null){
            throw new EntityNotFoundException();
        }

        userFound.setEmail(user.getEmail());
        userFound.setPassword(user.getPassword());

        userRepository.save(userFound);
        return ResponseEntity.ok("");
    }

}
