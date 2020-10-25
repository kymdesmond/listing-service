package com.cars.listingservice.graphql.query;

import com.cars.listingservice.entity.User;
import com.cars.listingservice.service.DatabaseService;
import com.cars.listingservice.service.QueryService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final QueryService queryService;

    private final DatabaseService databaseService;


    public CompletableFuture<List<User>> listUsers() {
        log.info("list users");
        return queryService.listUsers();
    }

    public CompletableFuture<User> findUserById(UUID id) {
        log.info("find user by id");
        return queryService.findUser(id);
    }

    public Optional<User> findUserByEmail(String email) {
        log.info("find user by email");
        return databaseService.findUserByEmail(email);
    }
}
