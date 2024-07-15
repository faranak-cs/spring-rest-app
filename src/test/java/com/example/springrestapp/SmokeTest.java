package com.example.springrestapp;


import com.example.springrestapp.contoller.api.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ProductController productController;

    // SMOKE TESTING ::
    // VERIFIES CRITICAL FUNCTIONALITIES LIKE
    // APPLICATION STARTS SUCCESSFULLY?

    @Test
    void contextLoads(){

        assertThat(productController).isNotNull();
    }

}
