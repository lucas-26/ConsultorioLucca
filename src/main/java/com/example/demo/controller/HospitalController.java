package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HospitalEntity;
import com.example.demo.repository.HospitalRepositoty;

@RestController
@RequestMapping("api/v1")
public class HospitalController {

	@Autowired
	private HospitalRepositoty hospitalRepository;
	
	@GetMapping("/hospital")
	public List<HospitalEntity> getAllHospital(){
		return hospitalRepository.findAll();
	}
	
	@GetMapping("/hospital/{id}")
	public ResponseEntity<HospitalEntity> getHospitalById(@PathVariable(value = "id") Long nCdHospital)
	throws ResourceNotFoundException {
		HospitalEntity hospitalEntity = hospitalRepository.findById(nCdHospital)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar o hospital por esse id:"+ nCdHospital));
		return ResponseEntity.ok().body(hospitalEntity);
	}
	

}
