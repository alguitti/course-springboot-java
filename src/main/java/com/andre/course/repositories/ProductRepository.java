package com.andre.course.repositories;

/****************************
 * Data Access Layer 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.course.entities.Product;

@Repository //Registra como repository para injeção de dependencia Autowired
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
