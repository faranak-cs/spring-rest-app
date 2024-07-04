package com.example.springrestapp.contoller.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    // REST ENDPOINTS

    // Hello
    @GetMapping("/hello")
    public String hello(){
        return "hello, hello";
    }

    // ADD NEW PRODUCT
    @PostMapping("/createProduct")
    public String createProduct(){
        return "Product is created!";
    }

    // GET ALL THE PRODUCTS
    @GetMapping("/getAllProducts")
    public String getAllProducts(){
        return "List of All Products!";
    }

    // GET PRODUCT BY ID
    @GetMapping("/getProductById")
    public String getProductById(){
        return "Product 1";
    }

    // UPDATE PRODUCT BY ID
    @PutMapping("/updateProductById")
    public String updateProductById(){
        return "Product is updated!";
    }

    // DELETE PRODUCT BY ID
    @DeleteMapping("/deleteProductById")
    public String deleteProductById(){
        return "Product is deleted!";
    }

}
