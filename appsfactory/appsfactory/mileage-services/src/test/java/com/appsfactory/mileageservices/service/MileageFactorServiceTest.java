package com.appsfactory.mileageservices.service;

import com.appsfactory.mileageservices.constants.MileageConstants;
import com.appsfactory.mileageservices.model.MileageTypeFactor;
import com.appsfactory.mileageservices.repository.AutoMileageRepository;
import com.appsfactory.mileageservices.service.impl.mileageFactorService.MileageFactorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MileageFactorServiceTest {


    @InjectMocks
    MileageFactorServiceImpl business;

    @Mock
    AutoMileageRepository autoMileageFactorRepository;

    @Test
    public void getMileageFactorTest(){

        when(autoMileageFactorRepository.findMileageByMileage(10)).
                thenReturn( new MileageTypeFactor(1, 0,50, 2.00, MileageConstants.STATUS_ACTIVE));

        MileageTypeFactor mileageFactor = business.getMileageFactorybyAutoMileage(10);

        Assert.assertNotNull(mileageFactor.getFactor());
    }

    @Test
    public void deleteMileageFactor(){

        when(autoMileageFactorRepository.findMileageByMinMileageAndMaxMileageAndStatus(0,100, MileageConstants.STATUS_ACTIVE)).
                thenReturn(new MileageTypeFactor(1, 0,100, 2.00, MileageConstants.STATUS_ACTIVE));

        business.deleteMileageFactor(0,100);
        verify(autoMileageFactorRepository, times(1)).save(any());

    }
}
