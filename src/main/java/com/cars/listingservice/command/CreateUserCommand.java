package com.cars.listingservice.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {

    @TargetAggregateIdentifier
    private UUID id;
    private String name;
    private String email;
    private String password;
}
