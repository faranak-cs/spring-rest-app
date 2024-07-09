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

    // HEALTH CHECK
    // http://localhost:8080/actuator/health

    // HELLO ✅
    @GetMapping("/hello")
    public String hello(){
        return "hello, hello";
    }

    // ADD NEW PRODUCT ✅
    @PostMapping("/createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
       // return "Product is created!";
       // return productService.createProduct(productName);
        return ResponseEntity
                .status(200)
                .body(productService.createProduct(productDTO));
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

    // UPDATE PRODUCT BY ID ✅
    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Integer id, @RequestBody String productName){
       // return "Product is updated!";
        return productService.updateProductById(id, productName);
    }

    // DELETE PRODUCT BY ID ✅
    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id){
        return productService.deleteProductById(id);
       // return "Product is deleted!";
    }

}
