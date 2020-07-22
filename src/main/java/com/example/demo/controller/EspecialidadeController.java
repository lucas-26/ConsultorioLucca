package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EspecialidadeEntity;
import com.example.demo.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/api/v1")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping("/especialidade")
	public List<EspecialidadeEntity> getAllEspecialidade(){
		return especialidadeRepository.findAll();
	}
	
	@GetMapping("/especialidade/{id}")
	public ResponseEntity<EspecialidadeEntity> getEspecialidadeById(@PathVariable(value = "id") Long nCdEspecialidade)
	throws ResourceNotFoundException {
		EspecialidadeEntity especialidadeEntity = especialidadeRepository.findById(nCdEspecialidade).
				orElseThrow(() -> new ResourceNotFoundException("especialidade não encontrada com esse id"+ nCdEspecialidade));
				return ResponseEntity.ok().body(especialidadeEntity);
	}
}
