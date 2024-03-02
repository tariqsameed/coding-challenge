package com.appsfactory.microservices.locationservices.utilities;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RegionalFactorUtil {

    public double generateRandomRegionalFactor(){
        double rangeMin = 0;
        double rangeMax = 5;
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }
}
