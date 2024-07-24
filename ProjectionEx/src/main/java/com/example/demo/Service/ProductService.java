package com.example.demo.Service;


import org.springframework.stereotype.Service;



import java.util.List;

import com.example.demo.DTO.Dto;
import com.example.demo.Entity.Product;

public interface ProductService {
	
	
	 List<Product> getAllProducts();

	    Product insertProductIntoDatabase(Product product);

	    Product getProductById(int id );

	    Product updateProduct(int id, Product product);

	    Product deleteProduct(int id);

	     List<Dto> getProductWithRequiredAttributes();

}
