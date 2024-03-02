package com.appsfactory.autoservices.service.autoFactor;

import com.appsfactory.autoservices.cosntants.AutoConstants;
import com.appsfactory.autoservices.model.AutoTypeFactor;
import com.appsfactory.autoservices.repository.AutoFactorRepository;
import com.appsfactory.autoservices.service.impl.autoFactor.AutoFactorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AutoFactorServiceTest {

    @InjectMocks
    AutoFactorServiceImpl business;

    @Mock
    AutoFactorRepository autoFactorRepository;

    @Test
    public void getAutoFactorTest(){

        when(autoFactorRepository.findByCarNameAndStatus("SUZUKI", AutoConstants.STATUS_ACTIVE)).
                thenReturn( new AutoTypeFactor(1, "SUZUKI","ACTIVE", 2.00));

        AutoTypeFactor autoFactor = business.getAutoTypeFactor("SUZUKI");

        Assert.assertEquals("SUZUKI", autoFactor.getCarName());
        Assert.assertNotNull(autoFactor.getFactor());
    }

    @Test
    public void deleteAutoFactor(){

        when(autoFactorRepository.findByCarNameAndStatus("SUZUKI", AutoConstants.STATUS_ACTIVE)).
                thenReturn(new AutoTypeFactor(1, "SUZUKI","ACTIVE", 2.00));

        business.deleteAutoTypeFactor("SUZUKI");
        verify(autoFactorRepository, times(1)).save(any());

    }
}
