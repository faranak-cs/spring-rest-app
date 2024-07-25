package com.example.springrestapp.contoller.api;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    // ONLY SERVICE LAYER TALK TO CONTROLLER LAYER

    private final ProductService productService;

    // REST ENDPOINTS

    // HEALTH CHECK
    // http://localhost:8080/actuator/health

    // HOME PAGE
    @GetMapping("/")
    public String homePage(){
        return "Home Page";
    }

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

        if (productDTO.getProductName() == null){
            return ResponseEntity
                    .status(400)
                    .build();
        }
        else {
            ProductDTO newProduct = productService.createProduct(productDTO);
            return ResponseEntity
                    .status(200)
                    .body(newProduct);
        }
    }

    // GET ALL THE PRODUCTS ✅
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
       // return "List of All Products!";
       // return productService.getAllProducts();

        List<ProductDTO> products = productService.getAllProducts();

        if (products.isEmpty()) {
             return ResponseEntity
                     .status(404)
                     .build();
        }
        else {
            return ResponseEntity
                    .status(200)
                    .body(products);
        }
    }

    // GET PRODUCT BY ID ✅
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){

        ProductDTO product = productService.getProductById(id);

        if (product != null) {
            return ResponseEntity
                    .status(200)
                    .body(product);
        }
        else {
            return ResponseEntity
                    .status(404)
                    .build();
        }
    }

    // UPDATE PRODUCT BY ID ✅
    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
       // return "Product is updated!";
       // return productService.updateProductById(id, productName);

        productDTO.setProductId(id);

        if (productDTO.getProductName() == null){
            return ResponseEntity
                    .status(400)
                    .build();
        }
        else {
            ProductDTO updatedProduct = productService.createProduct(productDTO);
            return ResponseEntity
                    .status(200)
                    .body(updatedProduct);
        }
    }

    // DELETE PRODUCT BY ID ✅
    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable Integer id){
       // return "Product is deleted!";
       // return productService.deleteProductById(id);
        return ResponseEntity
                .status(204)
                .body(productService.deleteProductById(id));
    }

}
