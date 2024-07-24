package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor 
@Data

public class Dto {
	
	public Dto(Integer id2, String name2, Double price2, Integer quantity) {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private Double price;
	private int qunatity;
	

}
