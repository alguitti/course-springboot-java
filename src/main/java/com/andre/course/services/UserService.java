package com.andre.course.services;

/*****************
 * Camada de Serviços para User
 ******************/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.course.entities.User;
import com.andre.course.repositories.UserRepository;

@Service //registra como componente do Spring e permite ser injetado com autowired
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
