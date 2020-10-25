package com.cars.listingservice.service;

import com.cars.listingservice.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface DatabaseService {

    Make addMake(Make make);
    Model addModel(Model model);
    Optional<Model> findModelById(UUID id);
    ModelVariant addModelVariant(ModelVariant modelVariant);
    Car addCar(Car car);
    List<Model> listModels();
    List<Make> listMakes();
    List<Make> findAllMakes();
    Optional<Make> findMakeById(UUID id);
    Make setMakeInTrash(Make make);
    User createUser(User user);
    Optional<User> findUserById(UUID id);
    Optional<User> findUserByEmail(String email);
    List<User> listUsers();
}
