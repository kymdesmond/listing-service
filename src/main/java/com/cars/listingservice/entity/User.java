package com.cars.listingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
}
