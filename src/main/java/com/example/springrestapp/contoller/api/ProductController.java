package com.example.springrestapp.contoller.api;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.model.ProductModel;
import com.example.springrestapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    // ONLY SERVICE LAYER TALK TO CONTROLLER LAYER

    private final ProductService productService;

    // REST ENDPOINTS

    // Hello ✅
    @GetMapping("/hello")
    public String hello(){
        return "hello, hello";
    }

    // ADD NEW PRODUCT ❌
    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody String productName){
       // return "Product is created!";
        return productService.createProduct(productName);
    }

    // GET ALL THE PRODUCTS ✅
    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(){
       // return "List of All Products!";
        return productService.getAllProducts();
    }

    // GET PRODUCT BY ID ✅
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    // UPDATE PRODUCT BY ID ❌
    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Integer id, @RequestBody String productName){
       // return "Product is updated!";
        return productService.updateProductById(id, productName);
    }

    // DELETE PRODUCT BY ID ❌
    @DeleteMapping("/deleteProductById")
    public String deleteProductById(){
        return "Product is deleted!";
    }

}
