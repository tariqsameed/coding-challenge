package com.appsfactory.microservices.locationservices.repository;

import com.appsfactory.microservices.locationservices.constants.LocationConstants;
import com.appsfactory.microservices.locationservices.model.Location;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void testFindAll() {
        List<Location> items = repository.findAll();
        Assert.assertTrue(items.size() > 0);
    }

    @Test
    public void testFindOne() {
        Location item = repository.findByPostLeitZahlAndStatus(12345, LocationConstants.STATUS_ACTIVE);

        Assert.assertEquals(12345,item.getPostLeitZahl().intValue());
    }
}
