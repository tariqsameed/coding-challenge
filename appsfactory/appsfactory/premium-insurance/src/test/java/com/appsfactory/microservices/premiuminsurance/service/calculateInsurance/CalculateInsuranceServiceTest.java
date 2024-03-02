package com.appsfactory.microservices.premiuminsurance.service.calculateInsurance;

import com.appsfactory.microservices.premiuminsurance.service.impl.calculateInsurance.CalculateInsuranceServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@Import(
        value = {
                CalculateInsuranceServiceImpl.class
        }
)
@RunWith(SpringRunner.class)
public class CalculateInsuranceServiceTest {

    @Autowired
    CalculateInsuranceServiceImpl calculateInsuranceServiceImpl;

    @Test
    public void testCalculateInsuranceByMileageAndAutoAndLocation() {
        double insuranceByMileageAndAutoAndLocation = calculateInsuranceServiceImpl.calculateInsuranceByMileageAndAutoAndLocation(1.00,1.00,1.00);
        Assert.assertEquals(1.00,insuranceByMileageAndAutoAndLocation, 0.00);
    }
}
