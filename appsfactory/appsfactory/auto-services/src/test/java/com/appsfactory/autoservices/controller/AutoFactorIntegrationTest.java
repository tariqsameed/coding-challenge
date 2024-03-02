package com.appsfactory.autoservices.controller;

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
public class AutoFactorIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String forObject = this.restTemplate.getForObject("/auto-factor/SUZUKI", String.class);
        JSONAssert.assertEquals("{carName: SUZUKI}",forObject,false);
    }
}
