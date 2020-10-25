package com.cars.listingservice.entity;

import com.cars.listingservice.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    private UUID id;
    private User user; //TODO: add Resolver for complex datatype
    private String name;
    private String logo;
    private String description;
    private String type;
    private Location location;
    private Date dateCreated;
    private Date dateUpdated;
    private Boolean inTrash;
}
