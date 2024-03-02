package com.appsfactory.autoservices.controller;

import com.appsfactory.autoservices.model.AutoTypeFactor;
import com.appsfactory.autoservices.service.autoFactor.AutoFactorService;

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
@WebMvcTest(AutoFactorController.class)
public class AutoFactorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutoFactorService autoFactorService;

    @Test
    public void testGetAutoFactorFactor() throws Exception {

        when(autoFactorService.getAutoTypeFactor("SUZUKI")).thenReturn(new AutoTypeFactor(1, "SUZUKI","ACTIVE", 2.00));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auto-factor/SUZUKI").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ carName: SUZUKI }"))
                .andReturn();

    }

    @Test
    public void testDeleteAutoFactor() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/auto-factor/SUZUKI").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isNoContent())
                .andReturn();

    }

}
