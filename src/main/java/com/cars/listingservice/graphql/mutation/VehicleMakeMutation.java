package com.cars.listingservice.graphql.mutation;

import com.cars.listingservice.entity.Make;
import com.cars.listingservice.service.DatabaseService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class VehicleMakeMutation implements GraphQLMutationResolver {

    private final DatabaseService databaseService;

    public Make addMake(String name, String description) {
        log.info("adding make: {}", name);
        Make make = new Make();
        make.setId(UUID.randomUUID());
        make.setName(name);
        make.setDescription(description);
        make.setDateCreated(new Date());
        make.setInTrash(false);
        return databaseService.addMake(make);
    }
}
