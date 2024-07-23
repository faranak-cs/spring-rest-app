package com.example.springrestapp.controller.integrationTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class ProductControllerHttpTestViaMockMvc {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void givenNewProduct_whenPost_thenReturns400() throws Exception {
        mockMvc
                .perform(post("/createProduct")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenProductId_whenGet_thenReturns404() throws Exception {
        mockMvc
                .perform(get("/getProductById/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


}
