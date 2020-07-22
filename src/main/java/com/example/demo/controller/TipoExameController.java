package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TipoExameEntity;
import com.example.demo.repository.TipoExameRepository;


@RestController
@RequestMapping("/v1/api")
public class TipoExameController {
	
	@Autowired
	private TipoExameRepository tipoExameRepository;
	
	@GetMapping("tipoExame")
	public List<TipoExameEntity> getAllTipoExame(){
		return tipoExameRepository.findAll();
	}
	
	@GetMapping("/tipoExame/{id}")
	public ResponseEntity<TipoExameEntity> getByIdTipoExame(@PathVariable(value = "id") Long nCdTpExame)
	throws ResourceNotFoundException{
		TipoExameEntity tipoExameEntity = tipoExameRepository.findById(nCdTpExame).orElseThrow(() -> new ResourceNotFoundException("Não foi possivél encontrar esse tipo exame com esse id" + nCdTpExame));
		return ResponseEntity.ok().body(tipoExameEntity);
	}

}
