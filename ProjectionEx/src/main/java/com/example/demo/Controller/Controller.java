package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Dto;
import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class Controller {
	
	  @Autowired
	    private ProductService productService;
	    @GetMapping("/all")
	    public List<Product> getAllProductsController() {
	        return  productService.getAllProducts();
	    }
	    

	    @PostMapping("/insert")
	    public Product insertProductInDb(@RequestBody Product product) {
	        return  productService.insertProductIntoDatabase(product);
	    }
	    

	    @GetMapping("/find/{id}")
	    public Product getProductById(@PathVariable int id) {
	        return  productService.getProductById(id);
	    }

	    @PutMapping("/update/{id}")
	    public Product updateProductById(@PathVariable int id,@RequestBody Product product) {
	       return productService.updateProduct(id,product);
	    }

	    @DeleteMapping("/delete/{id}")
	    public Product deleteProductById(@PathVariable int id) {
	       return productService.deleteProduct(id);
	    }

	    @GetMapping("/projections")
	    public List<Dto> getProjections() {
	        return  productService.getProductWithRequiredAttributes();
	    }




}
