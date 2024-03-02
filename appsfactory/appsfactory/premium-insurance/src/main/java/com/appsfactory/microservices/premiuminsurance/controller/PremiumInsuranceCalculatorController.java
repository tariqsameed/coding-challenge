package com.appsfactory.microservices.premiuminsurance.controller;

import com.appsfactory.microservices.premiuminsurance.entity.AnnualPremiumDetail;
import com.appsfactory.microservices.premiuminsurance.exceptions.NoRecordFoundException;
import com.appsfactory.microservices.premiuminsurance.service.calculateInsuranceManager.CalculateInsuranceMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RequestMapping("insurance-calculator")
@RestController
public class PremiumInsuranceCalculatorController {

    @Autowired
    CalculateInsuranceMangerService calculateInsuranceMangerService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{postcode}/{mileage}/{auto}")
    public AnnualPremiumDetail getAnnualPremiumInsurance(@PathVariable @NotNull Integer postcode,@PathVariable @NotNull Integer mileage,@PathVariable @NotNull String auto) throws NoRecordFoundException {
        AnnualPremiumDetail annualPremiumDetail =  calculateInsuranceMangerService.getAnnualPremiumInsuranceFromMileageAndPostCodeAndAuto(mileage, postcode, auto);
        return annualPremiumDetail;
    }

}
