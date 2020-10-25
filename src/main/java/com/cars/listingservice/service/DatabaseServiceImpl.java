package com.cars.listingservice.service;

import com.cars.listingservice.entity.*;
import com.cars.listingservice.repository.CarRepository;
import com.cars.listingservice.repository.MakeRepository;
import com.cars.listingservice.repository.ModelRepository;
import com.cars.listingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DatabaseServiceImpl implements DatabaseService{

    private final MakeRepository makeRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CarRepository carRepository;

    @Override
    public Make addMake(Make make) {
        make.setId(UUID.randomUUID());
        make.setDateCreated(new Date());
        make.setDateUpdated(new Date());
        make.setInTrash(false);
        return makeRepository.save(make);
    }

    @Override
    public Model addModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Optional<Model> findModelById(UUID id) {
        return modelRepository.findById(id);
    }

    @Override
    public ModelVariant addModelVariant(ModelVariant modelVariant) {
        return null;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Model> listModels() {
        return modelRepository.findAll();
    }

    @Override
    public List<Make> listMakes() {
        return makeRepository.findAll();
    }

    @Override
    public List<Make> findAllMakes() {
        return makeRepository.findAll();
    }

    @Override
    public Optional<Make> findMakeById(UUID id) {
        return makeRepository.findById(id);
    }

    @Override
    public Make setMakeInTrash(Make make) {
        make.setInTrash(true);
        return makeRepository.save(make);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
