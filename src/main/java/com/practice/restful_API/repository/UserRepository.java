package com.practice.restful_API.repository;


import com.practice.restful_API.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Provides CRUD operations for the User entity.
It abstracts the data access layer using Spring Data JPA.

JpaRepository<User, Long>: Extends JpaRepository which provides
methods for basic CRUD operations (e.g., findAll, findById, save, deleteById).
@Repository: Marks this interface as a repository, which is a
Spring stereotype for persistence layer beans.

 */

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
}
