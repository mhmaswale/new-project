package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.Dto;
import com.example.demo.Entity.Product;
import com.example.demo.Projection.ProductProjection;
import com.example.demo.Repo.ProductRepo;
import com.example.demo.Service.ProductService;

@Service

public class ProductServiceImpl implements ProductService{
	
	  @Autowired
	    private ProductRepo productRepo;
	  
	   @Override
	    public List<Product> getAllProducts() {
	        return productRepo.findAll();
	    }
	   @Override
	    public Product insertProductIntoDatabase(Product product) {
	        return productRepo.save(product);
	    }

	    @Override
	    public Product getProductById(int id) {
	        return productRepo.findById(id).get();
	    }

	    @Override
	    public Product updateProduct(int id, Product product) {
	        Product productFromDB = productRepo.findById(id).get();
	        productFromDB.setName(product.getName());
	        productFromDB.setPrice(product.getPrice());
	        productFromDB.setQuantity(product.getQuantity());
	        productRepo.save(productFromDB);
	        return productFromDB;
	    }

	    @Override
	    public Product deleteProduct(int id) {
	        Product product = productRepo.findById(id).get();
	        productRepo.deleteById(id);
	        return product;
	    }

	    @Override
	    public List<Dto> getProductWithRequiredAttributes() {
	        List<ProductProjection> productProjections = productRepo.getProductsWithRequiredAttributes();
	        List<Dto> productDTOS = new ArrayList<Dto>();
	        for (ProductProjection projections : productProjections) {

	            productDTOS.add(new Dto(projections.getId(),
	                    projections.getName(),
	                    projections.getPrice(),
	                    projections.getQuantity()));

	        }
	        return productDTOS;

	    }

}
