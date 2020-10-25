package com.cars.listingservice.service;

import com.cars.listingservice.entity.User;

import java.util.concurrent.CompletableFuture;

public interface CommandService {

    CompletableFuture<User> createUser(User user);
}
