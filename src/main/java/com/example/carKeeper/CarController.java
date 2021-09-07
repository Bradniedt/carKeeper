package com.example.carKeeper;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private final CarRepository repository;

    CarController(CarRepository repository) {
        this.repository = repository;
    }

    //Aggregate root
    //tag::get-aggregate-root[]
    @GetMapping("/cars")
    List<Car> all() {
        return repository.findAll();
    }

    @PostMapping("/cars")
    Car newCar(@RequestBody Car newCar){
        return repository.save(newCar);
    }

    @GetMapping("/cars/{id}")
    Car one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    @PutMapping("/cars/{id}")
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id){
        return repository.findById(id)
                .map(car -> {
                    car.setVin(newCar.getVin());
                    car.setMake(newCar.getMake());
                    car.setModel(newCar.getModel());
                    car.setYear(newCar.getYear());
                    car.setColor(newCar.getColor());
                    return repository.save(car);
                })
                .orElseGet(() ->{
                    newCar.setId(id);
                    return repository.save(newCar);
                });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
