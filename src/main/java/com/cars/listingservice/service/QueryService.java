package com.cars.listingservice.service;

import com.cars.listingservice.entity.Make;
import com.cars.listingservice.entity.Model;
import com.cars.listingservice.entity.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface QueryService {

    CompletableFuture<List<User>> listUsers();
    CompletableFuture<User> findUser(UUID id);
    CompletableFuture<List<Model>> listModels();
    CompletableFuture<List<Make>> listMakes();
}
