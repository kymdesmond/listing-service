package com.cars.listingservice.graphql.mutation;

import com.cars.listingservice.model.AuthData;
import com.cars.listingservice.entity.User;
import com.cars.listingservice.service.CommandService;
import com.cars.listingservice.service.DatabaseService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
@AllArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final CommandService commandService;
    private final DatabaseService databaseService;

    public User createUser(String name, AuthData authData) {

        log.info("creating user {}", name);
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(name);
        user.setEmail(authData.getEmail());
        user.setPassword(authData.getPassword());

        return this.databaseService.createUser(user);
//        return this.commandService.createUser(user);
    }
}
