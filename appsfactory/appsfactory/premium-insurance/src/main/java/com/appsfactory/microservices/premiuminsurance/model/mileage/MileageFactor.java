package com.appsfactory.microservices.premiuminsurance.model.mileage;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MileageFactor {

    Integer id;

    Integer minMileage;

    Integer maxMileage;

    Double factor;

    String status;
}
