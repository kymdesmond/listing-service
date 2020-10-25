package com.cars.listingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feature {

    private Map<String, Object> driverConvenience;
    private Map<String, Object> safety;
    private Map<String, Object> exterior;
    private Map<String, Object> interior;
    private Map<String, Object> technical;
    private Map<String, Object> dimension;
}
