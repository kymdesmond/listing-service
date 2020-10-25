package com.cars.listingservice.model;

import com.cars.listingservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInPayload {

    private String token;
    private User user;
}
