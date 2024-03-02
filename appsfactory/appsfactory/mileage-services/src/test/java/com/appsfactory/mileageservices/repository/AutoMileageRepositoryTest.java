package com.appsfactory.mileageservices.repository;

import com.appsfactory.mileageservices.model.MileageTypeFactor;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AutoMileageRepositoryTest {

    @Autowired
    AutoMileageRepository autoMileageRepository;

    @Test
    public void testFindAll() {
        List<MileageTypeFactor> items = autoMileageRepository.findAll();
        Assert.assertTrue(items.size() > 0);
    }

    @Test
    public void testFindOne() {
        MileageTypeFactor item = autoMileageRepository.findMileageByMileage(10);

        Assert.assertEquals(0,item.getMinMileage().intValue());
    }
}
