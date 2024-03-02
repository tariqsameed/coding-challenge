package com.appsfactory.microservices.premiuminsurance.service.calculateInsurance;

import javax.validation.constraints.NotNull;

public interface CalculateInsuranceService {

    Double calculateInsuranceByMileageAndAutoAndLocation(@NotNull double mileageFactor,
                                                                @NotNull double regionalFactor, @NotNull double autoTypeFactor);

}