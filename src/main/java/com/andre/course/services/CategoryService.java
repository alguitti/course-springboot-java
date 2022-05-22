package com.andre.course.services;

/*****************
 * Camada de Serviços para Order
 ******************/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.course.entities.Category;
import com.andre.course.entities.Order;
import com.andre.course.repositories.CategoryRepository;

@Service //registra como componente do Spring e permite ser injetado com autowired
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
