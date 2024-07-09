package com.example.springrestapp.mapper;

import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // MAPS FROM DTO TO ENTITY, AND VICE VERSA


    public static ProductModel toModel(ProductDTO productDTO){

        ProductModel productModel = new ProductModel();
        productModel.setProductId(productDTO.getProductId());
        productModel.setProductName(productDTO.getProductName());

        return productModel;
    }

    public static ProductDTO toDTO(ProductModel productModel){

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productModel.getProductId());
        productDTO.setProductName(productModel.getProductName());

        return productDTO;
    }

}
