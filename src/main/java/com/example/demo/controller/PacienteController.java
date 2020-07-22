package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PacienteEntity;
import com.example.demo.repository.PacienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API Rest ChatBot Lucca")
@RestController
@RequestMapping("/api/v1")
public class PacienteController {
	@Autowired 
	private PacienteRepository pacienterepository;
	
	@ApiOperation("Retorna Todos os Pacientes")
	@GetMapping("/paciente")
	public List<PacienteEntity> getAllPacientes(){
		return pacienterepository.findAll();
	}
	
	@ApiOperation("Retorna um paciente")
	@GetMapping("/paciente/{id}")
	public ResponseEntity<PacienteEntity> getPacienteById(@PathVariable (value = "id") Long nCdPaciente)
			throws ResourceNotFoundException {
		PacienteEntity pacienteentity = pacienterepository.findById(nCdPaciente).orElseThrow(() -> new ResourceNotFoundException("paciente não foi encontrado pelo numero: " + nCdPaciente));		
		return ResponseEntity.ok().body(pacienteentity);
	}
}
