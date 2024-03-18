package com.oProcess.mngnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oProcess.mngnt.dto.Productdto;
import com.oProcess.mngnt.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Products")
public class ProductConntroller {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/showproducts")
	private List <Productdto> showallproduct(){
		return productservice.showproducts();
		
	}
	
	@GetMapping("/showbyid/{p_Id}")
	Productdto showproductById(Productdto productdto,@PathVariable Long p_Id) {
		return productservice.showbyID(productdto, p_Id);
		
	}
	
	
	@PostMapping("/saveproducts")
	private Productdto enterproducts(@Valid @RequestBody Productdto productdto) {
		return productservice.saveProducts(productdto);
		
	}
	
	@PutMapping("/Updatebyid/{p_Id}")
	ResponseEntity<Productdto> updateProduct(@PathVariable Long p_Id,@RequestBody Productdto productdto){
		return productservice.updateProducts(p_Id, productdto);}
	
	@DeleteMapping("/dltbyid/{p_Id}")
    public ResponseEntity<String> deleteproduct(@PathVariable Long p_Id){
		productservice.dltproduct(p_Id);
		return ResponseEntity.ok("deleted  successfully");
		
	}

}
