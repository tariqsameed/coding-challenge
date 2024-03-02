package com.appsfactory.microservices.premiuminsurance.service.impl.calculateInsuranceManagerService;

import com.appsfactory.microservices.premiuminsurance.constants.PremiumInsuranceConstants;
import com.appsfactory.microservices.premiuminsurance.entity.AnnualPremiumDetail;
import com.appsfactory.microservices.premiuminsurance.exceptions.NoRecordFoundException;
import com.appsfactory.microservices.premiuminsurance.model.auto.AutoTypeFactor;
import com.appsfactory.microservices.premiuminsurance.model.location.LocationTypeFactor;
import com.appsfactory.microservices.premiuminsurance.model.mileage.MileageFactor;
import com.appsfactory.microservices.premiuminsurance.proxies.auto.AutoFactorProxy;
import com.appsfactory.microservices.premiuminsurance.proxies.location.LocationFactorProxy;
import com.appsfactory.microservices.premiuminsurance.proxies.mileage.MileageFactorProxy;
import com.appsfactory.microservices.premiuminsurance.repository.AnnualInsuranceDetailRepository;
import com.appsfactory.microservices.premiuminsurance.service.calculateInsurance.CalculateInsuranceService;
import com.appsfactory.microservices.premiuminsurance.service.calculateInsuranceManager.CalculateInsuranceMangerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CalculateInsuranceManagerServiceImpl implements CalculateInsuranceMangerService {

    @Autowired
    CalculateInsuranceService calculateInsuranceService;

    @Autowired
    MileageFactorProxy mileageFactorProxy;

    @Autowired
    AutoFactorProxy autoFactorProxy;

    @Autowired
    LocationFactorProxy locationFactorProxy;

    @Autowired
    AnnualInsuranceDetailRepository annualInsuranceDetailRepository;

    public AnnualPremiumDetail getAnnualPremiumInsuranceFromMileageAndPostCodeAndAuto(Integer mileage, Integer postcode, String auto) throws NoRecordFoundException {

        log.info(String.format("Calculate the Premium Insurance based on Mileage: %s, Postcode: %s, Auto: %s ",mileage,postcode,auto));
        AnnualPremiumDetail annualPremiumDetail;

        try {
            AutoTypeFactor autoTypeFactor = autoFactorProxy.getAutoTypeFactorByAutoType(auto);

            LocationTypeFactor locationTypeFactor = locationFactorProxy.getLocationTypeFactorByPostcode(postcode);

            MileageFactor mileageFactor = mileageFactorProxy.getMileageRangeFactorByMileage(mileage);

            Double annualInsuranceValue = calculateInsuranceService.calculateInsuranceByMileageAndAutoAndLocation(mileageFactor.getFactor(),
                    autoTypeFactor.getFactor(), autoTypeFactor.getFactor());

            annualPremiumDetail = getAnnualPremiumInsuranceDetail(mileage,autoTypeFactor,locationTypeFactor,mileageFactor, annualInsuranceValue);
        } catch (Exception e){
            log.error("Unable to Process the Request",e);
            throw new NoRecordFoundException("No Record Found");
        }

        return annualPremiumDetail;
    }

    private AnnualPremiumDetail getAnnualPremiumInsuranceDetail(Integer mileage, AutoTypeFactor autoTypeFactor, LocationTypeFactor locationTypeFactor, MileageFactor mileageFactor, Double annualInsurance ){

        AnnualPremiumDetail annualPremiumDetail = new AnnualPremiumDetail();

        annualPremiumDetail.setUuid(UUID.randomUUID());
        annualPremiumDetail.setCountryISO(locationTypeFactor.getCountryISO());
        annualPremiumDetail.setLocation(locationTypeFactor.getRegionFour());
        annualPremiumDetail.setPostcode(locationTypeFactor.getPostLeitZahl());
        annualPremiumDetail.setRegionalFactor(locationTypeFactor.getRegionalFactor());

        annualPremiumDetail.setAutoMileage(mileage);
        annualPremiumDetail.setMileageMinimumValue(mileageFactor.getMinMileage());
        annualPremiumDetail.setMileageMaximumValue(mileageFactor.getMaxMileage());
        annualPremiumDetail.setAutoMileageFactor(mileageFactor.getFactor());

        annualPremiumDetail.setAutoType(autoTypeFactor.getCarName());
        annualPremiumDetail.setAutoTypeFactor(autoTypeFactor.getFactor());

        annualPremiumDetail.setAnnualPremiumInsurance(annualInsurance);
        annualPremiumDetail.setCurrency(PremiumInsuranceConstants.DE_CURRENCY);

        annualInsuranceDetailRepository.save(annualPremiumDetail);
        return annualPremiumDetail;
    }
}
