package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MedicoEntity;
import com.example.demo.repository.MedicoRepository;

@RestController
@RequestMapping("api/v1")
public class MedicoController {

	@Autowired
	private MedicoRepository medicorepository;
	
	@GetMapping("/medico")
	public List<MedicoEntity> getAllMedicos()	{
		return medicorepository.findAll();
	}
	
	@GetMapping("/medico/{id}")
	public ResponseEntity<MedicoEntity>getMedicoById(@PathVariable(value="id")Long nCdMedico)throws ResourceNotFoundException{
		MedicoEntity medicoentity = medicorepository.findById(nCdMedico).orElseThrow(() -> new ResourceNotFoundException("Medico não encontrado com este numero" + nCdMedico));
		return ResponseEntity.ok().body(medicoentity);
	}

	
}
