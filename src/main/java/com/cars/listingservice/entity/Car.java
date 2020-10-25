package com.cars.listingservice.entity;

import com.cars.listingservice.model.Color;
import com.cars.listingservice.model.Engine;
import com.cars.listingservice.model.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    private UUID id;
    private String type;
    private String name;
    private String year;
    private String mileage;
    private Color color;
    private Engine engine;
    private String bodyStyle;
    private String description;
    private String currency;
    private Double price;
    private Boolean negotiable;
    private Boolean finance;
    private Seller seller;
    private Feature feature;
}
