package com.appsfactory.mileageservices.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MileageFactorIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String forObject = this.restTemplate.getForObject("/mileage-factor/100", String.class);
        JSONAssert.assertEquals("{ minMileage: 0 }",forObject,false);
    }
}
