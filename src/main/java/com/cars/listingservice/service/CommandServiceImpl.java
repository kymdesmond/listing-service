package com.cars.listingservice.service;

import com.cars.listingservice.command.CreateUserCommand;
import com.cars.listingservice.entity.User;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class CommandServiceImpl implements CommandService{

    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<User> createUser(User user) {
        return this.commandGateway.send(new CreateUserCommand(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        ));
    }
}
