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
import org.springframework.http.HttpStatusCode;

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

        // GIVEN
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Table");

        // WHEN
        HttpStatusCode expectedStatusCode = restTemplate
                .postForEntity("http://localhost:" + port + "/createProduct", productDTO, String.class)
                .getStatusCode();

        // THEN
        assertEquals(expectedStatusCode, HttpStatus.OK);
    }

    @Test
    void getProductByIdShouldReturnStatus404(){

        // GIVEN
        int id = 1;

        // WHEN
        HttpStatusCode expectedStatusCode = restTemplate
                .getForEntity("http://localhost:" + port + "/getProductById/" + id, String.class)
                .getStatusCode();

        // THEN
        assertEquals(expectedStatusCode, HttpStatus.NOT_FOUND);
    }

    @Test
    void getAllProductsShouldReturnStatus404(){

        // GIVEN

        // WHEN
        HttpStatusCode expectedStatusCode = restTemplate
                .getForEntity("http://localhost:" + port + "/getAllProducts", String.class)
                .getStatusCode();

        // THEN
        assertEquals(expectedStatusCode, HttpStatus.NOT_FOUND);
    }

    @Test
    void updateProductByIdShouldReturnStatus200(){

        // GIVEN
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Table");

        // WHEN
        HttpStatusCode expectedStatusCode = restTemplate
                .exchange("http://localhost:" + port + "/updateProductById/1",
                        HttpMethod.PUT,
                        new HttpEntity<>(productDTO),
                        ProductDTO.class)
                .getStatusCode();

        // THEN
        assertEquals(expectedStatusCode, HttpStatus.OK);
    }

    @Test
    void deleteProductByIdShouldReturnStatus204(){

        // GIVEN
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1);

        // WHEN
        HttpStatusCode expectedStatusCode = restTemplate
                .exchange("http://localhost:" + port + "/deleteProductById/1",
                        HttpMethod.DELETE,
                        new HttpEntity<>(productDTO),
                        ProductDTO.class)
                .getStatusCode();

        // THEN
        assertEquals(expectedStatusCode, HttpStatus.NO_CONTENT);
    }
}