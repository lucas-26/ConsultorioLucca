package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ExameEntity;
import com.example.demo.repository.ExameRepository;



@RestController
@RequestMapping("/api/v1")
public class ExameController {
	
	@Autowired
	private ExameRepository exameRepository;
	
	@GetMapping("/Exames")
	public List<ExameEntity> getAllExames(){
		return exameRepository.findAll();
	}
	
	@GetMapping("/Exame/{id}")
	public ResponseEntity<ExameEntity> getExamesById(@PathVariable(value = "id") Long nCdExame)
	throws ResourceNotFoundException{
		ExameEntity exameEntity = exameRepository.findById(nCdExame).orElseThrow(() -> new ResourceNotFoundException("Não foi possivél encontrar essa exame com esse id" + nCdExame));
		return ResponseEntity.ok().body(exameEntity);
	}
}
