package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HospitalContatosEntity;
import com.example.demo.repository.HospitalContatosRepository;

@RestController
@RequestMapping("api/v1")
public class HospitalContatosController {
	
	@Autowired
	private HospitalContatosRepository hospitalContatosRepository;
	
	@GetMapping("/HospitalContatos")
	public List<HospitalContatosEntity> getAllHospitalContatos(){
		return hospitalContatosRepository.findAll();
	}
	
	@GetMapping("/HospitalContatos/{id}")
	public ResponseEntity<HospitalContatosEntity> getHospitalContatosFindById(@PathVariable(name="id")Long nCdContato)
		throws ResourceNotFoundException{
			HospitalContatosEntity hospitalContatosEntity = hospitalContatosRepository.findById(nCdContato).orElseThrow(
			() -> new ResourceNotFoundException("não foi possivel encontrar esse hospital contatos com esse id:" + nCdContato));
			return ResponseEntity.ok().body(hospitalContatosEntity);
			
		}
	}

