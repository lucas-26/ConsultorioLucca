package com.example.demo.controller;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PacientesContatosEntity;
import com.example.demo.repository.PacientesContatosRepository;

@RestController
@RequestMapping("api/v1")
public class PacientesContatosController {

	@Autowired
	private PacientesContatosRepository pacienteContatosRepository;
	
	@GetMapping("/pacientesContatosController")
	public List<PacientesContatosEntity> getAllPacientesContatos(){
		return pacienteContatosRepository.findAll();
	}
	
	@GetMapping("/pacienteContatos/{id}")
	public ResponseEntity<PacientesContatosEntity> getContatosPacienteById(@PathVariable(name = "id")Long nCdContato)
		throws ResourceNotFoundException{
		PacientesContatosEntity pacienteContatosEntity = pacienteContatosRepository.findById(nCdContato).orElseThrow( 
			() -> new ResourceNotFoundException("não foi possivél encontrar esse paciente contato com esse id:" + nCdContato));
			return ResponseEntity.ok().body(pacienteContatosEntity);
	}
}
