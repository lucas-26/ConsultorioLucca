package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MedicoContatosEntity;
import com.example.demo.repository.MedicoContatosRepository;

@RestController
@RequestMapping("api/v1")
public class MedicoContatosController {

	@Autowired
	private MedicoContatosRepository medicoContatosRepository;
	
	@GetMapping("/medicoContatos")
	public List<MedicoContatosEntity> getAllMedicoContatos(){
		return medicoContatosRepository.findAll();
	}
	
	@GetMapping("/medicoContatos/{id>")
	public ResponseEntity<MedicoContatosEntity> getMedicoContatosById(@PathVariable(name = "id") Long nCdContato)
	throws ResourceNotFoundException{
		MedicoContatosEntity medicoContatosEntity = medicoContatosRepository.findById(nCdContato).orElseThrow(
			() -> new ResourceNotFoundException("não foi possivél encontrar esse medico contato com esse id:" + nCdContato));
			return ResponseEntity.ok().body(medicoContatosEntity);
	}
}
