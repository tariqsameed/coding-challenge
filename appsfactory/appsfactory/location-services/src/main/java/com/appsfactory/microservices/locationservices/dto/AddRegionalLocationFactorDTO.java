package com.appsfactory.microservices.locationservices.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@Data
public class AddRegionalLocationFactorDTO {


    @NotNull
    String countryISO;

    String stateISO;

    String regionOne;

    String regionTwo;

    String regionThree;

    String regionFour;

    @NotNull
    Integer postLeitZahl;

    String ort;

    @Min(0)
    @Max(5)
    Double regionalFactor;
}
