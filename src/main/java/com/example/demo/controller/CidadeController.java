package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CidadeEntity;
import com.example.demo.repository.CidadeRepository;

@RestController
@RequestMapping("api/v1")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository; 
	
	@GetMapping("/cidade")
	public List<CidadeEntity> getAllCidades(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/cidade/{id}")
	public ResponseEntity<CidadeEntity> getCidadeById(@PathVariable(value = "id") Long 	nCdCidade)
	throws ResourceNotFoundException {
		CidadeEntity cidadeentity = cidadeRepository.findById(nCdCidade).orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar a cidade a partir desse id: " + nCdCidade ));
		return ResponseEntity.ok().body(cidadeentity);
	}
}
