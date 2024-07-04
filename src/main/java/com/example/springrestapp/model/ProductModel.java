package com.example.springrestapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductModel {
    @Id
    private Integer productId;
    private String productName;
}
