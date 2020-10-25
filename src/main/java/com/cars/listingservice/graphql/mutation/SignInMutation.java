package com.cars.listingservice.graphql.mutation;

import com.cars.listingservice.model.AuthData;
import com.cars.listingservice.model.SignInPayload;
import com.cars.listingservice.entity.User;
import com.cars.listingservice.service.DatabaseService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class SignInMutation implements GraphQLMutationResolver {

    private DatabaseService databaseService;

    public  SignInMutation(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public SignInPayload signinUser(AuthData auth) throws IllegalAccessException {
        log.info("signing in user: {}", auth.getEmail());
        Optional<User> user = databaseService.findUserByEmail(auth.getEmail());
        if(user.isPresent()) {
            if (user.get().getPassword().equals(auth.getPassword())) {
                return new SignInPayload(user.get().getId().toString(), user.get());
            }
            throw new GraphQLException("Invalid credentials");
        }
        throw new GraphQLException("User not found");
    }
}
