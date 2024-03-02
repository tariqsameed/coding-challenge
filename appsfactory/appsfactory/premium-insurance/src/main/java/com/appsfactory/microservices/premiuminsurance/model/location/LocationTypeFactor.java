package com.appsfactory.microservices.premiuminsurance.model.location;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LocationTypeFactor {

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
}


