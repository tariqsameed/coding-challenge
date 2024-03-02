package com.appsfactory.microservices.premiuminsurance.service.impl.calculateInsurance;

import com.appsfactory.microservices.premiuminsurance.service.calculateInsurance.CalculateInsuranceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculateInsuranceServiceImpl implements CalculateInsuranceService {


    @Override
    public Double calculateInsuranceByMileageAndAutoAndLocation(double mileageFactor, double regionalFactor, double autoTypeFactor) {

        BigDecimal annualInsuranceValue = null;

        BigDecimal mileageInsuraceValue =  new BigDecimal(mileageFactor).setScale(2,RoundingMode.HALF_EVEN);

        BigDecimal regionalFactorBd = new BigDecimal(regionalFactor).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal autoFactorBd = new BigDecimal(autoTypeFactor).setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal regionalAndAutoFactorValue= regionalFactorBd.multiply(autoFactorBd).setScale(2, RoundingMode.HALF_EVEN);

        annualInsuranceValue = mileageInsuraceValue.multiply(regionalAndAutoFactorValue).setScale(2, RoundingMode.HALF_EVEN);

        return annualInsuranceValue.doubleValue();
    }
}
