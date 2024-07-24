package com.example.demo.Repo;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Product;
import com.example.demo.Projection.ProductProjection;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "select id,name,price,quantity from product_table", nativeQuery = true)
    List<ProductProjection> getProductsWithRequiredAttributes();

}
