package com.example.carKeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarKeeperApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CarKeeperApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
