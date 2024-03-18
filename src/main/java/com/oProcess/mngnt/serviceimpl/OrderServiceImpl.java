package com.oProcess.mngnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oProcess.mngnt.dto.Orderdto;
import com.oProcess.mngnt.exception.OrderNotFoundException;
import com.oProcess.mngnt.reposiroty.OrderRepository;
import com.oProcess.mngnt.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderrepository;
	

	@Override
	public List<Orderdto> showOrders() {
		return orderrepository.findAll();
	}

	@Override
	public Orderdto saveOrders(Orderdto orderdto) {
		return orderrepository.save(orderdto);
	}

	@Override
	public Orderdto showbyID(Orderdto orderdto, Long orderId) {
		
		Orderdto getOrderbyIds =orderrepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Product not found with id " + orderId));
		
		
		return getOrderbyIds;
	}

	@Override
	public ResponseEntity<Orderdto> updateorders(long orderId, Orderdto orderdto) {
		
		Orderdto updateOrderbyIds =orderrepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Product not found with id " + orderId));
		
		updateOrderbyIds.setOrderId(orderdto.getOrderId());
		updateOrderbyIds.setQuantity(orderdto.getQuantity());
		updateOrderbyIds.setTotalAmount(orderdto.getTotalAmount());
		
		
		orderrepository.save(updateOrderbyIds);
		
		
		return ResponseEntity.ok(updateOrderbyIds);
	}

	@Override
	public void dltorders(Long orderId) {
		
		Orderdto showOrderbyIds =orderrepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Product not found with id " + orderId));
		
		orderrepository.deleteById(orderId);
	}

}
