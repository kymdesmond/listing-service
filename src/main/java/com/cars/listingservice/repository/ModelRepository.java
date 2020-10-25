package com.cars.listingservice.repository;

import com.cars.listingservice.entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ModelRepository extends MongoRepository<Model, UUID> {
}
