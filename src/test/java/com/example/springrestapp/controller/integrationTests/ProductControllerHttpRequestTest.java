package com.example.springrestapp.controller.integrationTests;


import com.example.springrestapp.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

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
    void createProductShouldReturnStatus200(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Table");

        assertEquals(this.restTemplate.postForEntity("http://localhost:" + port + "/createProduct",
               productDTO, String.class).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getProductByIdShouldReturnStatus200(){
        assertEquals(this.restTemplate.getForEntity("http://localhost:" + port + "/getProductById/1",
                String.class).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getAllProductsShouldReturnStatus200(){
        assertEquals(this.restTemplate.getForEntity("http://localhost:" + port + "/getAllProducts",
                String.class).getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void updateProductByIdShouldReturnStatus200(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(null);

        assertEquals(this.restTemplate.exchange("http://localhost:" + port + "/updateProductById/1",
                HttpMethod.PUT,
                new HttpEntity<>(productDTO),
                ProductDTO.class).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void deleteProductByIdShouldReturnStatus200(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1);

        assertEquals(this.restTemplate.exchange("http://localhost:" + port + "/deleteProductById/1",
                HttpMethod.DELETE,
                new HttpEntity<>(productDTO),
                ProductDTO.class).getStatusCode(), HttpStatus.NO_CONTENT);
    }
}