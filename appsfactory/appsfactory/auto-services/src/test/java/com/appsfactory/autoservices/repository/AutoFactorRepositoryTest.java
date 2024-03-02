package com.appsfactory.autoservices.repository;
import com.appsfactory.autoservices.cosntants.AutoConstants;
import com.appsfactory.autoservices.model.AutoTypeFactor;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AutoFactorRepositoryTest {

    @Autowired
    AutoFactorRepository autoFactorRepository;

    @Test
    public void testFindAll() {
        List<AutoTypeFactor> items = autoFactorRepository.findAll();
        Assert.assertTrue(items.size() > 0);
    }

    @Test
    public void testFindOne() {
        AutoTypeFactor item = autoFactorRepository.findByCarNameAndStatus("SUZUKI", AutoConstants.STATUS_ACTIVE);

        Assert.assertEquals("SUZUKI",item.getCarName());
    }


}
