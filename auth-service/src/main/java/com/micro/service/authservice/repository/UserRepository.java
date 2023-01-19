package com.micro.service.authservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.micro.service.authservice.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
