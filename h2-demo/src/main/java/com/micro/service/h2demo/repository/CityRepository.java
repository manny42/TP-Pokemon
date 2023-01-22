package com.micro.service.h2demo.repository;

import com.micro.service.h2demo.model.City;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CityRepository extends CrudRepository<City, Integer> {
}
