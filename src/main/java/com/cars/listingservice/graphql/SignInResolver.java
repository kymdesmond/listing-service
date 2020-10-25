package com.cars.listingservice.graphql;

import com.cars.listingservice.model.SignInPayload;
import com.cars.listingservice.entity.User;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class SignInResolver implements GraphQLResolver<SignInPayload> {

    public User user(SignInPayload payload) {
        return payload.getUser();
    }
}
