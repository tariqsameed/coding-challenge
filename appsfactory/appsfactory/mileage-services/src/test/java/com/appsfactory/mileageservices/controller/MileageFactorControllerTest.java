package com.appsfactory.mileageservices.controller;

import com.appsfactory.mileageservices.contoller.mileageFactor.MileageFactorController;
import com.appsfactory.mileageservices.model.MileageTypeFactor;
import com.appsfactory.mileageservices.service.mileageFactorSerivce.MileageFactorService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MileageFactorController.class)
public class MileageFactorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MileageFactorService mileageFactorService;

    @Test
    public void testGetAutoMileageFactorFactor() throws Exception {

        when(mileageFactorService.getMileageFactorybyAutoMileage(100)).thenReturn(new MileageTypeFactor(1, 0,100,1.00,"ACTIVE"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mileage-factor/100").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ minMileage: 0 }"))
                .andReturn();

    }

    @Test
    public void testDeleteAutoMileageFactor() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/mileage-factor/0/1000").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isNoContent())
                .andReturn();

    }

}
