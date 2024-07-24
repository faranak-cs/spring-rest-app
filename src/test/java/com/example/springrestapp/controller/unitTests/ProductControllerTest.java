package com.example.springrestapp.controller.unitTests;

import com.example.springrestapp.contoller.api.ProductController;
import com.example.springrestapp.dto.ProductDTO;
import com.example.springrestapp.mapper.ProductMapper;
import com.example.springrestapp.model.ProductModel;
import com.example.springrestapp.repository.ProductRepository;
import com.example.springrestapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    // CLASS UNDER TEST - cut
    private ProductController cut;

    private ProductService mockService;

    @Mock
    private ProductRepository mockRepo;
    @Mock
    private ProductMapper mockMapper;


    @BeforeEach
    void setup(){
        mockService = new ProductService(mockRepo, mockMapper);
        cut = new ProductController(mockService);
    }

    @Test
    public void givenProductId_whenGetProduct_thenReturns200(){
        // GIVEN
        final ProductModel productModel = new ProductModel();
        final ProductDTO productDTO = new ProductDTO();

        // WHEN
        when(mockRepo.findById(1)).thenReturn(Optional.of(productModel));
        when(mockService.getProductById(1)).thenReturn(productDTO);

        // THEN
        assertEquals(cut.getProductById(1).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void givenNewProduct_whenPostProduct_thenReturn200(){
        // GIVEN
        final ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Table");
        final ProductModel productModel = new ProductModel();

        // WHEN
        when(mockMapper.toModel(productDTO)).thenReturn(productModel);
        when(mockService.createProduct(productDTO)).thenReturn(productDTO);

        // THEN
        assertEquals(cut.createProduct(productDTO).getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void givenProductList_whenGetAll_thenReturns404(){
        // GIVEN
        final List<ProductModel> productModelList = new ArrayList<>();

        final List<ProductDTO> productDTOList = new ArrayList<>();

        // WHEN
        when(mockRepo.findAll()).thenReturn(productModelList);
        when(mockService.getAllProducts()).thenReturn(productDTOList);

        // THEN
        assertEquals(cut.getAllProducts().getStatusCode(), HttpStatus.NOT_FOUND);
    }


    
}

/*
*
*
*
        final ProductModel productModel = new ProductModel();
        productModel.setProductId(1);
        productModel.setProductName("Table");
        productModelList.add(productModel);

        final ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1);
        productDTO.setProductName("Table");
        productDTOList.add(productDTO);

*
*
* */
