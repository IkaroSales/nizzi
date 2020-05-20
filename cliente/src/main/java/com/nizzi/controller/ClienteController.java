package com.nizzi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nizzi.model.Cliente;
import com.nizzi.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteRepository clienteDAO;

	@Autowired
	public ClienteController(ClienteRepository clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(clienteDAO.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(clienteDAO.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Cliente cliente) {
		clienteDAO.save(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		clienteDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
