package com.cars.listingservice.graphql.mutation;

import com.cars.listingservice.entity.Make;
import com.cars.listingservice.entity.Model;
import com.cars.listingservice.service.DatabaseService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ModelMutation implements GraphQLMutationResolver {

    private final DatabaseService databaseService;

    public Model addModel(String name, String description, UUID makeId) {
        log.info("adding model: {}", name);
        Model model = new Model();
        model.setId(UUID.randomUUID());
        Optional<Make> make = databaseService.findMakeById(makeId);
        if(make.isPresent()) {
            model.setMake(make.get().getId());
        }
        model.setName(name);
        model.setDescription(description);
        model.setDateCreated(new Date());
        model.setDateUpdated(new Date());
        model.setInTrash(false);

        return databaseService.addModel(model);
    }
}
