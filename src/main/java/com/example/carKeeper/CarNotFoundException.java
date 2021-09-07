package com.example.carKeeper;

class CarNotFoundException extends RuntimeException {

    CarNotFoundException(Long id){
        super("Could not find car " + id);
    }
}
