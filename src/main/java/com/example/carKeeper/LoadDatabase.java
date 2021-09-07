package com.example.carKeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Car("1FTEE4FH3MLD48055", "Ford", "Ranger", "2021", "Rapid Red")));
            log.info("Preloading " + repository.save(new Car("JTEBT14R348016808", "Toyota", "4Runner", "2004", "White")));
        };
    }
}
