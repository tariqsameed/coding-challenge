package com.appsfactory.microservices.premiuminsurance.repository;

import com.appsfactory.microservices.premiuminsurance.entity.AnnualPremiumDetail;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnnualInsuranceDetailRepositoryTest {

    @Autowired
    AnnualInsuranceDetailRepository annualInsuranceDetailRepository;

    @Test
    public void testFindAll() {
        List<AnnualPremiumDetail> items = annualInsuranceDetailRepository.findAll();
        Assert.assertTrue(items.size() > 0);
    }
}
