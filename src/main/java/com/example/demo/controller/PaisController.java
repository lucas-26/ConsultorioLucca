package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PaisEntity;
import com.example.demo.repository.PaisRepository;

@RestController
@RequestMapping("/api/v1")
public class PaisController {

	@Autowired
	private PaisRepository paisrepository;
	
	@GetMapping("/pais")
	public List<PaisEntity> getAllPais(){
		return paisrepository.findAll();
	}
	
	@GetMapping("/pais/{id}")
	public ResponseEntity<PaisEntity> getPaisById(@PathVariable (value = "id") Long nCdPais)
	throws ResourceNotFoundException{
		PaisEntity paisentity = paisrepository.findById(nCdPais).orElseThrow(() -> new ResourceNotFoundException("Não foi possivel achar o pais por esse id" + nCdPais));
		return ResponseEntity.ok().body(paisentity);
	}
}
