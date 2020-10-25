package com.cars.listingservice.projection;

import com.cars.listingservice.entity.Make;
import com.cars.listingservice.query.FindAllMakesQuery;
import com.cars.listingservice.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MakeProjection {

    private final DatabaseService databaseService;

    @QueryHandler
    public List<Make> handle(FindAllMakesQuery findAllMakesQuery) {
        log.info("listing all makes");
        return databaseService.listMakes();
    }
}
