package com.appsfactory.microservices.locationservices;

import com.appsfactory.microservices.locationservices.service.impl.locationScheduler.LocationSeedingServiceImpl;
import com.appsfactory.microservices.locationservices.service.locationScheduler.LocationSeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LocationServicesApplication {


	public static void main(String[] args) {

		SpringApplication.run(LocationServicesApplication.class, args);

	}

}
