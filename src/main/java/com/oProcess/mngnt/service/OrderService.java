package com.oProcess.mngnt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.oProcess.mngnt.dto.Orderdto;

public interface OrderService {
	
	List<Orderdto> showOrders();

	Orderdto saveOrders(Orderdto orderdto);

	Orderdto showbyID(Orderdto orderdto, Long orderId);

	public ResponseEntity<Orderdto> updateorders(@PathVariable long orderId, @RequestBody Orderdto orderdto);

	void dltorders(@PathVariable Long orderId);


}
