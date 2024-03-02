package com.appsfactory.microservices.premiuminsurance.service.calculateInsuranceManager;

import com.appsfactory.microservices.premiuminsurance.entity.AnnualPremiumDetail;
import com.appsfactory.microservices.premiuminsurance.exceptions.NoRecordFoundException;

public interface CalculateInsuranceMangerService {

    public AnnualPremiumDetail getAnnualPremiumInsuranceFromMileageAndPostCodeAndAuto(Integer mileage, Integer postcode, String auto) throws NoRecordFoundException;
}
