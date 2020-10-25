package com.cars.listingservice.repository;

import com.cars.listingservice.entity.Make;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MakeRepository extends MongoRepository<Make, UUID> {
}
