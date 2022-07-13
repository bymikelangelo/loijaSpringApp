package com.loija.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loija.core.model.FactoryOrder;
import com.loija.core.model.MyUser;
import com.loija.core.repository.FactoryOrderRepository;

@Service
public class FactoryOrderService {

	@Autowired
	public FactoryOrderRepository repository;
	
	public List<FactoryOrder> listOrders() {
		return repository.findAll();
	}
	
	public FactoryOrder addOrder(FactoryOrder order) {
		return repository.save(order);
	}
	
	public String deleteOrder(int id) {
		try {
			Optional<FactoryOrder> order = repository.findById(id);
			repository.delete(order.get());
			return "Orden eliminada";
		}
		catch (Exception e) {
			return "Se ha producido un error";
		}
	}
	
	public FactoryOrder getOrderById(int id) {
		Optional<FactoryOrder> order = repository.findById(id);
		return order.get();
	}
	
}
