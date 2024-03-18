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

import com.oProcess.mngnt.dto.Orderdto;
import com.oProcess.mngnt.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@GetMapping("/showorders")
	private List <Orderdto> showAllOrders(){
		return orderservice.showOrders();
		
	}
	
	@GetMapping("/showbyid/{orderId}")
	Orderdto showOrderById(Orderdto orderdto,@PathVariable Long orderId) {
		return orderservice.showbyID(orderdto, orderId);
		
	}
	
	@PostMapping("/saveorrders")
	private Orderdto enterNewOrder(@Valid @RequestBody Orderdto orderdto) {
		return orderservice.saveOrders(orderdto);
		
	}
	
	@PutMapping("/Updatebyid/{orderId}")
	ResponseEntity<String> updateOrders(@PathVariable Long orderId,@RequestBody Orderdto orderdto){
		orderservice.updateorders(orderId, orderdto);
		
		return ResponseEntity.ok("Updated successfully");
		}
	
	@DeleteMapping("/dltbyid/{orderId}")
    public ResponseEntity<String> deleteorders(@PathVariable Long orderId){
		orderservice.dltorders(orderId);
		return ResponseEntity.ok("deleted  successfully"+" OrderId -->"+ orderId);
		
	}
}
