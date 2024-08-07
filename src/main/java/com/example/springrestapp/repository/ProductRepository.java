package com.example.springrestapp.repository;

import com.example.springrestapp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    // REPOSITORY LAYER



}
