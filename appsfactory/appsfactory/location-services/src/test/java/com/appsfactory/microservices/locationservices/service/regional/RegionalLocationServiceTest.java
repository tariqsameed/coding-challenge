package com.appsfactory.microservices.locationservices.service.regional;

import com.appsfactory.microservices.locationservices.constants.LocationConstants;
import com.appsfactory.microservices.locationservices.dto.AddRegionalLocationFactorDTO;
import com.appsfactory.microservices.locationservices.model.Location;
import com.appsfactory.microservices.locationservices.repository.LocationRepository;
import com.appsfactory.microservices.locationservices.service.impl.regional.RegionalLocationServiceImpl;
import com.appsfactory.microservices.locationservices.utilities.RegionalFactorUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegionalLocationServiceTest {

    @InjectMocks
    RegionalLocationServiceImpl business;

    @Mock
    LocationRepository locationRepository;

    @Mock
    RegionalFactorUtil regionalFactorUtil;

    @Test
    public void getRegionalLocationFactorTest(){

        when(locationRepository.findByPostLeitZahlAndStatus(12345, LocationConstants.STATUS_ACTIVE)).
                thenReturn( new Location("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 12345, "Berlin", 2.00,"ACTIVE"));

        Location regionalLocationFactor = business.getRegionalLocationFactor(12345);

        Assert.assertEquals(12345, regionalLocationFactor.getPostLeitZahl().intValue());
        Assert.assertNotNull(regionalLocationFactor.getPostLeitZahl().intValue());
    }

    @Test
    public void addRegionalLocationFactorTest(){

        when(regionalFactorUtil.generateRandomRegionalFactor()).
                thenReturn(2.0);

        AddRegionalLocationFactorDTO addRegionalLocationFactorDTO = new AddRegionalLocationFactorDTO("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 12345, "Berlin", 2.00);

        Location regionalLocationFactor = business.addRegionalLocationFactor(addRegionalLocationFactorDTO);

        verify(locationRepository, times(1)).save(any());

    }

    @Test
    public void updateRegionalLocationFactor(){

        AddRegionalLocationFactorDTO addRegionalLocationFactorDTO = new AddRegionalLocationFactorDTO("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 12345, "Berlin", 2.0);

        when(locationRepository.findByPostLeitZahlAndStatus(12345, LocationConstants.STATUS_ACTIVE)).
                thenReturn( new Location("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 12345, "Berlin", 2.00,"ACTIVE"));

        business.updateRegionalLocationFactor(12345,addRegionalLocationFactorDTO);
        verify(locationRepository, times(1)).save(any());

    }

    @Test
    public void deleteRegionalLocationFactor(){

        when(locationRepository.findByPostLeitZahlAndStatus(12345, LocationConstants.STATUS_ACTIVE)).
                thenReturn( new Location("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 12345, "Berlin", 2.00,"ACTIVE"));

        business.deleteRegionalLocationFactor(12345);
        verify(locationRepository, times(1)).save(any());

    }
}
