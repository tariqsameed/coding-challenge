package com.appsfactory.microservices.locationservices.utilities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = RegionalFactorUtil.class)
@RunWith(SpringRunner.class)
public class RegionalFactorUtilTest {

    @Autowired
    RegionalFactorUtil regionalFactorUtil;

    @Test
    public void testgenerateRandomRegionalFactor(){

        double regionalFactor = regionalFactorUtil.generateRandomRegionalFactor();
        Assert.assertTrue(regionalFactor <= 5.00);
        Assert.assertTrue(regionalFactor >= 0.00);
    }
}
