package com.example.springrestapp.service;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.mapper.ProductMapper;
import com.example.springrestapp.model.ProductModel;
import com.example.springrestapp.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    // SERVICE LAYER

    // ONLY REPOSITORY LAYER TALK TO SERVICE LAYER
    private ProductRepository productRepository;

    // USE FOR DESERIALIZATION
    private ProductMapper productMapper;


    // GET PRODUCT BY ID FROM REPOSITORY LAYER
    public ResponseEntity<?> getProductById(Integer id) {

        Optional<ProductModel> productModel = productRepository.findById(id);

        if(productModel.isPresent()){
            return new ResponseEntity<>(productModel, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
