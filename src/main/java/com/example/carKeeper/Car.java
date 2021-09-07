package com.example.carKeeper;

import javax.persistence.GeneratedValue;
import java.util.Objects;

public class Car {

    private @Id @GeneratedValue Long id;
    private String vin;
    private String make;
    private String model;
    private String year;
    private String color;

    Car(String vinStr, String makeStr, String modelStr, String yearStr, String colorStr){
        this.vin = vinStr;
        this.make = makeStr;
        this.model = modelStr;
        this.year = yearStr;
        this.color = colorStr;
    }

    public Long getId(){
        return this.id;
    }

    public String getVin(){
        return this.vin;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public String getYear(){
        return this.year;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Car))
            return false;
        Car car = (Car) o;
        return Objects.equals(this.id, car.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.vin, this.make, this.model, this.year, this.color);
    }

    @Override
    public String toString(){
        return "Car{" + "vin=" + this.vin + ", make=" + this.make + ", model=" + this.model + ", year=" + this.year + ", color=" + this.color + "}";
    }
}
