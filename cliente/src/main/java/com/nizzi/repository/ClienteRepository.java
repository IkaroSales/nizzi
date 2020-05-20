package com.nizzi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nizzi.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);
}
