package com.appsfactory.microservices.locationservices.utilities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = PostCodeFilePreprocessors.class)
@RunWith(SpringRunner.class)
public class PostCodeFilePreprocessorsTest {

    @Autowired
    PostCodeFilePreprocessors postCodeFilePreprocessors;

    @Test
    public void testRemoveTrailingAndLeadingCharacters(){

        String dirtyValue = " \"Baden-Württemberg\"";
        String expectedValue = "Baden-Württemberg";
        String actualValue = postCodeFilePreprocessors.removeTrailingAndLeadingCharacters(dirtyValue);
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetCountryISOPreprocessedValue(){

        String dirtyValue = "\"DE\"";
        String expectedValue = "DE";
        String actualValue = postCodeFilePreprocessors.getCountryISOPreprocessedValue(dirtyValue);
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testGetPostLietZahlValue(){

        String dirtyValue = " \"12345\"";
        int expectedValue = 12345;
        String actualValue = postCodeFilePreprocessors.getPostLietZahlValue(dirtyValue);
        Assert.assertEquals(expectedValue, Integer.valueOf(actualValue).intValue());

    }


}
