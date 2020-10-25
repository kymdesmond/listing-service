package com.cars.listingservice.event;

import lombok.Data;

import java.util.UUID;

@Data
public class UserCreatedEvent {

    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
}
