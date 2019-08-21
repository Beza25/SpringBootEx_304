package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    private int year;

    public Car(@NotNull String make, @NotNull String model,@NotNull int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car() {
    }


    public long getId() {
        return id;
    }
    public String getMake() { return make; }

    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }



    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public void setId(long id) {
        this.id = id;
    }
}
