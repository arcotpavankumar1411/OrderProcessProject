package com.oProcess.mngnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oProcess.mngnt.dto.Productdto;
import com.oProcess.mngnt.exception.ProductNotFoundException;
import com.oProcess.mngnt.reposiroty.ProductRepository;
import com.oProcess.mngnt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public List<Productdto> showproducts() {
		
		return productrepository.findAll();
	}

	@Override
	public Productdto saveProducts(Productdto productdto) {
		
		return productrepository.save(productdto);
	}

	



	@Override
	public ResponseEntity<Productdto> updateProducts(long p_Id, Productdto productdto) {
		
		Productdto updateProducts =productrepository.findById(p_Id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id " + p_Id));
		
		updateProducts.setP_Id(productdto.getP_Id());
		updateProducts.setProductName(productdto.getProductName());
		updateProducts.setPrice(productdto.getPrice());
		
		productrepository.save(updateProducts);
		
		
		return ResponseEntity.ok(updateProducts);
	}

	@Override
	public Productdto showbyID(Productdto productdto, Long p_Id) {
		
		Productdto updateProducts =productrepository.findById(p_Id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id " + p_Id));
		
		
		return updateProducts;
	}

	@Override
	public void dltproduct(Long p_Id) {
		
		Productdto dltProducts =productrepository.findById(p_Id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id " + p_Id));
		
		productrepository.deleteById(p_Id);
	}

	

	
	
	
	

}
