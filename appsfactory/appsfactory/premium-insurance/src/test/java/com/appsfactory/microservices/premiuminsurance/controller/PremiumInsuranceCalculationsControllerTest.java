package com.appsfactory.microservices.premiuminsurance.controller;

import com.appsfactory.microservices.premiuminsurance.entity.AnnualPremiumDetail;
import com.appsfactory.microservices.premiuminsurance.service.calculateInsuranceManager.CalculateInsuranceMangerService;
import org.springframework.web.bind.annotation.RestController;

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

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PremiumInsuranceCalculatorController.class)
public class PremiumInsuranceCalculationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateInsuranceMangerService calculateInsuranceMangerService;

    @Test
    public void testAnnualPremiumInsuranceCalculations() throws Exception {

        when(calculateInsuranceMangerService.getAnnualPremiumInsuranceFromMileageAndPostCodeAndAuto(100,12345,"SUZUKI"))
                .thenReturn(new AnnualPremiumDetail(UUID.fromString("8ab9a900-47aa-11ec-81d3-0242ac130003"),"DE", "Freiburg",12345, 1.00, "SUZUKI", 1.00, 100, 0, 1000, 1.00, "EURO", 100.00));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/insurance-calculator/12345/100/SUZUKI").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ annualPremiumInsurance: 100.00 }"))
                .andReturn();

    }
}
