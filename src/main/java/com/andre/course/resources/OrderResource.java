package com.andre.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.course.entities.Order;
import com.andre.course.services.OrderService;

/**********************************
 * Camada de recursos 
 * Rest Controllers
 * @author andre
 *********************************/

@RestController
@RequestMapping(value = "/Orders")
public class OrderResource {

	//injeção de dependencia para camada de serviços
	@Autowired
	private OrderService service;
	
	//endpoint
	//tipo especifico do Sptring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		//retorna resposta sucesso http e no corpo poe a lista
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
