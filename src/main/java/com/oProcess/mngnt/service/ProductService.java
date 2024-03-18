package com.oProcess.mngnt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.oProcess.mngnt.dto.Productdto;

public interface ProductService {
	
	List<Productdto> showproducts();
	
	Productdto saveProducts(Productdto productdto);
	
	Productdto  showbyID(Productdto productdto,Long p_Id);
	
    public ResponseEntity<Productdto> updateProducts(@PathVariable long p_Id,@RequestBody Productdto productdto);

	
	void dltproduct(@PathVariable Long p_Id);
}
