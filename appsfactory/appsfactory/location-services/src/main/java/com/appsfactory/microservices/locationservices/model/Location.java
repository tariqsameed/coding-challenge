package com.appsfactory.microservices.locationservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.security.KeyStore;

@NoArgsConstructor
@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryISO;

    private String stateISO;

    private String regionOne;

    private String regionTwo;

    private String regionThree;

    private String regionFour;

    private Integer postLeitZahl;

    private String ort;

    private Double regionalFactor;

    private String status;



    public Location(String countryISO, String stateISO, String regionOne, String regionTwo, String regionThree,String regionFour, Integer postLeitZahl, String ort, Double regionalFactor, String status) {

        this.countryISO =countryISO;
        this.stateISO = stateISO;
        this.regionOne = regionOne;
        this.regionTwo = regionTwo;
        this.regionThree = regionThree;
        this.regionFour = regionFour;
        this.postLeitZahl = postLeitZahl;
        this.ort = ort;
        this.regionalFactor = regionalFactor;
        this.status = status;
    }

}
