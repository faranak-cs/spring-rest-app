package com.example.springrestapp.contoller.api;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Controller",
        description = "perform CRUD operations on products db")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ProductController {

    // ONLY SERVICE LAYER TALK TO CONTROLLER LAYER

    private final ProductService productService;

    // REST ENDPOINTS

    @Operation(description = "test api to add a product into db")
    @PostMapping("/products")
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

    @Operation(description = "test api to get all products from db")
    @GetMapping("/products")
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

    @Operation(description = "test api to get a product by id from db")
    @GetMapping("/products/{id}")
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

    @Operation(description = "test api to update a product in db")
    @PutMapping("/products/{id}")
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

    @Operation(description = "test api to delete a product from db")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable Integer id){
       // return "Product is deleted!";
       // return productService.deleteProductById(id);
        return ResponseEntity
                .status(204)
                .body(productService.deleteProductById(id));
    }

}
