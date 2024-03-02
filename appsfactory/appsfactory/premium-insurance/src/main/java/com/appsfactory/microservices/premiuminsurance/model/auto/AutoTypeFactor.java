package com.appsfactory.microservices.premiuminsurance.model.auto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AutoTypeFactor {

    Integer id;

    String carName;

    String status;

    Double factor;

}
