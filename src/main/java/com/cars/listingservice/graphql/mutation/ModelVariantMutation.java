package com.cars.listingservice.graphql.mutation;

import com.cars.listingservice.entity.Model;
import com.cars.listingservice.entity.ModelVariant;
import com.cars.listingservice.service.DatabaseService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class ModelVariantMutation implements GraphQLMutationResolver {

    private final DatabaseService databaseService;

    public ModelVariant addModelVariant(UUID modelId, String name, String description) {

        ModelVariant modelVariant = new ModelVariant();
        Optional<Model> model = databaseService.findModelById(modelId);
        if(model.isPresent()) {
            modelVariant.setModel(model.get().getId());
        }
        modelVariant.setName(name);
        modelVariant.setDescription(description);
        modelVariant.setDateCreated(new Date());
        modelVariant.setDateUpdated(new Date());

        return databaseService.addModelVariant(modelVariant);
    }
}
