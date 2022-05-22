package com.andre.course.services;

/*****************
 * Camada de Serviços para Product
 ******************/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.course.entities.Product;
import com.andre.course.repositories.ProductRepository;

@Service //registra como componente do Spring e permite ser injetado com autowired
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
