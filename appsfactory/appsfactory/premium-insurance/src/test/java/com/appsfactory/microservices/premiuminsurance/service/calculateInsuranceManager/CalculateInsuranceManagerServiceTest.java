package com.appsfactory.microservices.premiuminsurance.service.calculateInsuranceManager;

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
import com.appsfactory.microservices.premiuminsurance.service.impl.calculateInsuranceManagerService.CalculateInsuranceManagerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculateInsuranceManagerServiceTest {

    @InjectMocks
    CalculateInsuranceManagerServiceImpl business;

    @Mock
    CalculateInsuranceService calculateInsuranceService;

    @Mock
    MileageFactorProxy mileageFactorProxy;

    @Mock
    AutoFactorProxy autoFactorProxy;

    @Mock
    LocationFactorProxy locationFactorProxy;

    @Mock
    AnnualInsuranceDetailRepository annualInsuranceDetailRepository;

    @Test
    public void testCalculateInsuranceByMileageAndAutoAndLocation() throws NoRecordFoundException {

        when(calculateInsuranceService.calculateInsuranceByMileageAndAutoAndLocation(1.00,1.00,1.00)).
                thenReturn(1.00);

        when(mileageFactorProxy.getMileageRangeFactorByMileage(100)).
                thenReturn(new MileageFactor(1,0,1000,1.00,"ACTIVE"));

        when(autoFactorProxy.getAutoTypeFactorByAutoType("SUZUKI")).
                thenReturn(new AutoTypeFactor(1,"SUZUKI","ACTIVE",1.00));

        when(locationFactorProxy.getLocationTypeFactorByPostcode(12345)).
                thenReturn(new LocationTypeFactor(1l,"DE","DE-WH","Bayern","Munich", "Munich", "Munich", 12345,"Munich",1.00,"ACTIVE"));


        AnnualPremiumDetail premiumDetail = business.getAnnualPremiumInsuranceFromMileageAndPostCodeAndAuto(100, 12345, "SUZUKI");

        Assert.assertEquals(1.00, premiumDetail.getAnnualPremiumInsurance(),0.00);
        verify(annualInsuranceDetailRepository, times(1)).save(any());
    }
}
