package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TipoConsultaEntity;
import com.example.demo.repository.TipoConsultaRepository;

@RestController
@RequestMapping("api/v1")
public class TipoConsultaController {

	@Autowired
	private TipoConsultaRepository tipoConsultaRepository;
	
	@GetMapping("/TipoConsulta")
	public List<TipoConsultaEntity> getAllTipoConsulta(){
		return tipoConsultaRepository.findAll();
	}
	
	@GetMapping("/TipoConsulta/{id}")
	private ResponseEntity<TipoConsultaEntity> getTipoConsultaById(@PathVariable(name ="id") Long nCdTpConsulta)
	throws ResourceNotFoundException{
		TipoConsultaEntity tipoConsultaEntity = tipoConsultaRepository.findById(nCdTpConsulta).orElseThrow(
				() -> new ResourceNotFoundException("Não foi possivél encontrar esse tipo consulta com esse id" + nCdTpConsulta));
				return ResponseEntity.ok().body(tipoConsultaEntity);
	}
	
}
