package com.practice.restful_API.controller;


import com.practice.restful_API.model.user;
import com.practice.restful_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
Defines the RESTful API endpoints and handles HTTP requests.
It uses UserService to process requests and return responses.
 */

@RestController
    @RequestMapping("/api/users")
    public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping
        public List<user> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public ResponseEntity<user> getUserById(@PathVariable Long id) {
            return userService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public user createUser(@RequestBody user user) {
            return userService.createUser(user);
        }

        @PutMapping("/{id}")
        public ResponseEntity<user> updateUser(@PathVariable Long id, @RequestBody user userDetails) {
            return ResponseEntity.ok(userService.updateUser(id, userDetails));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
    }

