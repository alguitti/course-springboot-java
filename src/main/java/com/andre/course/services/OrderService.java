package com.andre.course.services;

/*****************
 * Camada de Serviços para Order
 ******************/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.course.entities.Order;
import com.andre.course.repositories.OrderRepository;

@Service //registra como componente do Spring e permite ser injetado com autowired
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
