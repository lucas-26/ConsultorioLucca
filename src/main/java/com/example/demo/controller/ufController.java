package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UfEntity;
import com.example.demo.repository.UfRepository;

@RestController
@RequestMapping("api/v1")
public class ufController {

	@Autowired
	private UfRepository ufrepository;
	
	@GetMapping("/uf")
	public List<UfEntity> getallUf(){
		return ufrepository.findAll();
	}
	
	@GetMapping("/uf/{id}")
	public ResponseEntity<UfEntity> getUfById(@PathVariable(value = "id") Long nCdUF)
	throws ResourceNotFoundException {
		UfEntity ufentity = ufrepository.findById(nCdUF).orElseThrow(() -> new ResourceNotFoundException("impossivél encontrar esse uf com esse numero: "+ nCdUF));
		return ResponseEntity.ok().body(ufentity);
	}
}
