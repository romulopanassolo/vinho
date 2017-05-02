package com.ubots.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ubots.prova.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("FROM Cliente c WHERE c.cpf = :cpf ") 
	public Cliente findByCpf(@Param("cpf") String cpf);
	
}
