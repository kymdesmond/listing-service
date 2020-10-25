package com.cars.listingservice.graphql.query;

import com.cars.listingservice.entity.Model;
import com.cars.listingservice.service.QueryService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class ModelQuery implements GraphQLQueryResolver {

    private final QueryService queryService;

    public CompletableFuture<List<Model>> listModels() {
        return queryService.listModels();
    }
}
