package com.andre.course.repositories;

/****************************
 * Data Access Layer 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.course.entities.User;

@Repository //Registra como repository para injeção de dependencia Autowired
public interface UserRepository extends JpaRepository<User, Long>{
	//framework automaticamente implementa 
}
