package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Car car;
        car = new Car("Toyota", "XE", 2016);
        repository.save(car);

        car = new Car("Tesla", "model3 ", 2019);
        repository.save(car);

        car = new Car("Honda", "XE",2018);
        repository.save(car);
    }

}
