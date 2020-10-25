package com.cars.listingservice.projection;

import com.cars.listingservice.entity.Model;
import com.cars.listingservice.query.FIndAllModelsQuery;
import com.cars.listingservice.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ModelProjection {

    private final DatabaseService databaseService;

    @QueryHandler
    public List<Model> handle(FIndAllModelsQuery fIndAllModelsQuery) {
        log.info("listing all models");
        return databaseService.listModels();
    }
}
