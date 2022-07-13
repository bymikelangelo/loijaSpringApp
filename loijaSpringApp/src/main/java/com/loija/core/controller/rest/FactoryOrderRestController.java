package com.loija.core.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loija.core.model.FactoryOrder;
import com.loija.core.service.FactoryOrderService;
import com.loija.core.service.UserService;

@RestController
@RequestMapping("rest/fOrders")
public class FactoryOrderRestController {
	
	@Autowired
	private FactoryOrderService orderService;
	
	@Autowired UserService userService;
	
	@GetMapping({"", "/list"})
	public List<FactoryOrder> listOrders() {
		return orderService.listOrders();
	}
	
	@PostMapping("/save")
	public FactoryOrder save(@RequestBody FactoryOrder order) {
		order.setCreatedBy(userService.getUserByUsername(order.getCreatedBy().getUsername()));
		return orderService.addOrder(order);
	}
	
	@PostMapping("/completed")
	public FactoryOrder update(@RequestBody FactoryOrder order) {
		order.setCompletedBy(userService.getUserByUsername(order.getCompletedBy().getUsername()));
		return orderService.addOrder(order);
	}

}
