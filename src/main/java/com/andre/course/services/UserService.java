package com.andre.course.services;

/*****************
 * Camada de Serviços para User
 ******************/

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andre.course.entities.User;
import com.andre.course.repositories.UserRepository;
import com.andre.course.services.exceptions.DatabaseException;
import com.andre.course.services.exceptions.ResourceNotFoundException;

@Service // registra como componente do Spring e permite ser injetado com autowired
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			Optional<User> entity = Optional.ofNullable(repository.getOne(id));
			entity.ifPresent(e -> updateData(e, obj));
			if (!entity.isPresent()) {
				entity = repository.findById(id);
				User ent = entity.get();
				updateData(ent, obj);
				return repository.save(ent);
			}
			User ent = entity.get();
			return repository.save(ent);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		/***************************
		 * User entity = repository.getOne(id); updateData(entity, obj); return
		 * repository.save(entity);
		 */
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
