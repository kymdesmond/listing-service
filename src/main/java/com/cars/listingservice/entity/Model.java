package com.cars.listingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    @Id
    private UUID id;
    private UUID make;
    private String name;
    private String description;
    private Date dateCreated;
    private Date dateUpdated;
    private Boolean inTrash;
}
