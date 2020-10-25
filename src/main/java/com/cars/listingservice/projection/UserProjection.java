package com.cars.listingservice.projection;

import com.cars.listingservice.entity.User;
import com.cars.listingservice.event.UserCreatedEvent;
import com.cars.listingservice.query.FindAllUsersQuery;
import com.cars.listingservice.query.FindUserQuery;
import com.cars.listingservice.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserProjection {

    private final DatabaseService databaseService;

    @EventHandler
    public void on(UserCreatedEvent event) {
        log.info("Handling create user event, user id: {}", event.getId());
        User user = new User(event.getId(), event.getName(), event.getEmail(), event.getPassword());
        this.databaseService.createUser(user);
    }

    @QueryHandler
    public User handle(FindUserQuery findUserQuery) {
        log.info("finding user {}", findUserQuery.getId());
        return this.databaseService.findUserById(findUserQuery.getId()).orElse(null);
    }

    @QueryHandler
    public List<User> handle(FindAllUsersQuery findAllUsersQuery) {
        log.info("listing all users");
        return this.databaseService.listUsers();
    }
}
