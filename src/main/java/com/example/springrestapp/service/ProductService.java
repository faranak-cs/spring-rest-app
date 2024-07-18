package com.example.springrestapp.service;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.mapper.ProductMapper;
import com.example.springrestapp.model.ProductModel;
import com.example.springrestapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ProductDTO getProductById(Integer id) {

        Optional<ProductModel> productModel = productRepository.findById(id);

        if(productModel.isPresent()){
            return productMapper.toDTO(productModel.get());
        }
        else {
            return null;
        }
    }


    // GET ALL PRODUCTS FROM REPOSITORY LAYER ✅
    public List<ProductDTO> getAllProducts() {

        List<ProductModel> productModelList = productRepository.findAll();

        // MODEL PRODUCT LIST IS NOT EMPTY
        if (!productModelList.isEmpty()) {

            List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();

            // DTO PRODUCT LIST
            for (ProductModel product : productModelList) {
                productDTOList.add(productMapper.toDTO(product));
            }

            return productDTOList;
        }
        // MODEL PRODUCT LIST IS EMPTY
        else {
            return null;
        }
    }

    // CREATE NEW PRODUCT INTO REPOSITORY LAYER ✅
    public ProductDTO createProduct(ProductDTO productDTO){

        final ProductModel productModel = productMapper.toModel(productDTO);

        productRepository.save(productModel);

        return productMapper.toDTO(productModel);

    }

    // UPDATE PRODUCT BY ID FROM REPOSITORY LAYER ✅
    public ProductDTO updateProductById(Integer id, ProductDTO productDTO){

        productDTO.setProductId(id);

        final ProductModel productModel = productMapper.toModel(productDTO);

        productRepository.save(productModel);

        return productMapper.toDTO(productModel);
    }

    // DELETE PRODUCT BY ID FROM REPOSITORY LAYER ✅
    public ProductDTO deleteProductById(Integer id){

        productRepository.deleteById(id);

        return null;
    }
}
