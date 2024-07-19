package com.practice.restful_API.service;

import com.practice.restful_API.model.user;
import com.practice.restful_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Contains the business logic and service methods for managing User entities.
 It interacts with the UserRepository to perform CRUD operations.

 @Service: Marks this class as a service component, which contains business logic.
@Autowired: Injects the UserRepository dependency.
Service Methods:
getAllUsers(): Retrieves all users from the repository.
getUserById(Long id): Retrieves a user by ID.
createUser(User user): Creates a new user.
updateUser(Long id, User userDetails): Updates an existing user.
deleteUser(Long id): Deletes a user by ID.
 */

import java.util.List;
import java.util.Optional;

    @Service
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        public List<user> getAllUsers() {
            return userRepository.findAll();
        }

        public Optional<user> getUserById(Long id) {
            return userRepository.findById(id);
        }

        public user createUser(user user) {
            return userRepository.save(user);
        }

        public user updateUser(Long id, user userDetails) {
            user user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }

        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }
    }
}
