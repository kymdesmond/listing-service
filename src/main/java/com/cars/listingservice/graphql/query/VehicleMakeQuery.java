package com.cars.listingservice.graphql.query;

import com.cars.listingservice.entity.Make;
import com.cars.listingservice.service.DatabaseService;
import com.cars.listingservice.service.QueryService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
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
public class VehicleMakeQuery implements GraphQLQueryResolver {

    private final DatabaseService databaseService;
    private final QueryService queryService;


    public CompletableFuture<List<Make>> listMakes() {
        return queryService.listMakes();
    }

    public Optional<Make> findMakeById(UUID id) {
        return databaseService.findMakeById(id);
    }
}
