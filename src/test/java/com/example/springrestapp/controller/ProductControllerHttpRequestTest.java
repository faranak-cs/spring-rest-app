package com.example.springrestapp.controller;


import com.example.springrestapp.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerHttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloShouldReturnDefaultMessage(){
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello",
                String.class)).contains("hello, hello");
    }

    @Test
    void getProductByIdShouldReturnStatus200(){
        assertEquals(this.restTemplate.getForEntity("http://localhost:" + port + "/getProductById/1",
                String.class).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void createProductShouldReturnStatus200(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Table");

        assertEquals(this.restTemplate.postForEntity("http://localhost:" + port + "/createProduct",
                productDTO, String.class).getStatusCode(), HttpStatus.OK);
    }

}
