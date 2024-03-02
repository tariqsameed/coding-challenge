package com.appsfactory.microservices.locationservices;

import com.appsfactory.microservices.locationservices.service.locationScheduler.LocationSeedingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Slf4j
@Component
public class DatabaseSeedingHandler implements ApplicationRunner {

    @Autowired
    LocationSeedingService locationSeedingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try{
            log.info("Loading the Initial Data into InMemory Database");

            locationSeedingService.startFileLoading();

            log.info("Finished the Loading of Initial Data into InMemory Database");

        }catch (Exception e){
            log.info("Unable to Load Initial Data into InMemory Database");
            throw new FileNotFoundException();
        }

    }
}
