package com.andre.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.course.entities.User;
import com.andre.course.services.UserService;

/**********************************
 * Camada de recursos 
 * Rest Controllers
 * @author andre
 *********************************/

@RestController
@RequestMapping(value = "/User")
public class UserResource {

	//injeção de dependencia para camada de serviços
	@Autowired
	private UserService service;
	
	//endpoint
	//tipo especifico do Sptring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		//retorna resposta sucesso http e no corpo poe a lista
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
