package com.example.springrestapp.service;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.mapper.ProductMapper;
import com.example.springrestapp.model.ProductModel;
import com.example.springrestapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    // SERVICE LAYER

    // ONLY REPOSITORY LAYER TALK TO SERVICE LAYER
    private final ProductRepository productRepository;

    // USE FOR DESERIALIZATION
    private final ProductMapper productMapper;


    // GET PRODUCT BY ID FROM REPOSITORY LAYER ✅
    public ResponseEntity<?> getProductById(Integer id) {

        Optional<ProductModel> productModel = productRepository.findById(id);

        if(productModel.isPresent()){
           // return new ResponseEntity<>(productModel, HttpStatus.OK);
            return ResponseEntity.status(200).body(productModel.get());
        }
        else {
           // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            return ResponseEntity.status(404).body(null);
        }
    }


    // GET ALL PRODUCTS FROM REPOSITORY LAYER ✅
    public ResponseEntity<?> getAllProducts(){

        List<ProductModel> productModelList = productRepository.findAll();

        if(!productModelList.isEmpty()){
            return ResponseEntity.status(200).body(productModelList);

            //
        }
        else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // CREATE NEW PRODUCT INTO REPOSITORY LAYER ✅
    public ProductDTO createProduct(ProductDTO productDTO){

        final ProductModel productModel = productMapper.toModel(productDTO);

        productRepository.save(productModel);

        return productMapper.toDTO(productModel);

    }

    // UPDATE PRODUCT BY ID FROM REPOSITORY LAYER ✅
    public ResponseEntity<?> updateProductById(Integer id, String productName){

        final ProductModel productModel = new ProductModel();
        productModel.setProductName(productName);
        productModel.setProductId(id);

        productRepository.save(productModel);

        return ResponseEntity.status(200).body(productModel);
    }

    // DELETE PRODUCT BY ID FROM REPOSITORY LAYER ❌
    public ResponseEntity<?> deleteProductById(Integer id){

        productRepository.deleteById(id);

        return ResponseEntity.status(204).build();
    }
}
