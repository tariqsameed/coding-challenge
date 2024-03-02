package com.appsfactory.microservices.locationservices.controller;

import com.appsfactory.microservices.locationservices.dto.AddRegionalLocationFactorDTO;
import com.appsfactory.microservices.locationservices.model.Location;
import com.appsfactory.microservices.locationservices.service.regional.RegionalLocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostCodesController.class)
public class PostCodesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegionalLocationService regionalLocationService;

    @Test
    public void testGetRegionalLocationFactor() throws Exception {

        when(regionalLocationService.getRegionalLocationFactor(12345)).thenReturn(new Location("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 12345, "Berlin", 2.00,"ACTIVE"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/postcode-factor/12345").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ countryISO: countryISO }"))
                .andReturn();

    }

    @Test
    public void testAddRegionalLocationFactor() throws Exception {

        MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

        AddRegionalLocationFactorDTO addRegionalLocationFactorDTO = new AddRegionalLocationFactorDTO("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 123456, "Berlin", 2.0);
        when(regionalLocationService.addRegionalLocationFactor(addRegionalLocationFactorDTO)).
                thenReturn(new Location("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 123456, "Berlin", 2.00,"ACTIVE"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(addRegionalLocationFactorDTO );


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/postcode-factor").contentType(MediaType.APPLICATION_JSON).content(requestJson);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ countryISO: countryISO }"))
                .andReturn();

    }

    @Test
    public void testUpdateRegionalLocationFactor() throws Exception {

        MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

        AddRegionalLocationFactorDTO addRegionalLocationFactorDTO = new AddRegionalLocationFactorDTO("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 123456, "Berlin", 2.0);
        when(regionalLocationService.updateRegionalLocationFactor(123456,addRegionalLocationFactorDTO)).
                thenReturn(new Location("countryISO", "stateISO", "regionOne", "regionTwo", "regionThree","regionFour", 123456, "Berlin", 2.00,"ACTIVE"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(addRegionalLocationFactorDTO );


        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/postcode-factor/123456").contentType(MediaType.APPLICATION_JSON).content(requestJson);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ countryISO: countryISO }"))
                .andReturn();

    }

    @Test
    public void testDeleteRegionalLocationFactor() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/postcode-factor/12345").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isNoContent())
                .andReturn();

    }

}
