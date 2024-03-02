package com.appsfactory.microservices.locationservices.controller;

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
public class PostCodeCodesControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String forObject = this.restTemplate.getForObject("/postcode-factor/12345", String.class);
        JSONAssert.assertEquals("{id:1}",forObject,false);
    }
}
