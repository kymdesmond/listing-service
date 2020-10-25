package com.cars.listingservice.service;

import com.cars.listingservice.entity.Make;
import com.cars.listingservice.entity.Model;
import com.cars.listingservice.entity.User;
import com.cars.listingservice.query.FIndAllModelsQuery;
import com.cars.listingservice.query.FindAllMakesQuery;
import com.cars.listingservice.query.FindAllUsersQuery;
import com.cars.listingservice.query.FindUserQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class QueryServiceImpl implements QueryService{

    private final QueryGateway queryGateway;

    @Override
    public CompletableFuture<List<User>> listUsers() {
        return queryGateway.query(new FindAllUsersQuery(), ResponseTypes.multipleInstancesOf(User.class));
    }

    @Override
    public CompletableFuture<User> findUser(UUID id) {
        return queryGateway.query(
                new FindUserQuery(id), ResponseTypes.instanceOf(User.class)
        );
    }

    @Override
    public CompletableFuture<List<Model>> listModels() {
        return queryGateway.query(new FIndAllModelsQuery(), ResponseTypes.multipleInstancesOf(Model.class));
    }

    @Override
    public CompletableFuture<List<Make>> listMakes() {
        return queryGateway.query(new FindAllMakesQuery(), ResponseTypes.multipleInstancesOf(Make.class));
    }
}
