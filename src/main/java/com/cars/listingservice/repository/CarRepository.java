package com.cars.listingservice.repository;

import com.cars.listingservice.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CarRepository extends MongoRepository<Car, UUID> {
}
