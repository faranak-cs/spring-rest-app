package com.example.springrestapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    @JsonProperty("ID")
    private Integer productId;
    @JsonProperty("PRODUCT_NAME")
    private String productName;
}
