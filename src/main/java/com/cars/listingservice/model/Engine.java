package com.cars.listingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engine {

    private String fuel;
    private String size;
    private String torque;
    private String bhp;
    private String driveTrain;
    private String transmission;
    private String description;
}
