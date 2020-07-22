package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ConsultaEntity;
import com.example.demo.repository.ConsultaRepository;

@RestController
@RequestMapping("/api/v1")
public class ConusltaController {

	@Autowired
	private ConsultaRepository consultarepository;
	
	@GetMapping("/Consulta")
	public List<ConsultaEntity> getAllConsulta(){
		return consultarepository.findAll();
	}
	
	@GetMapping("/Consulta/{id}")
	public ResponseEntity<ConsultaEntity> getConsultaById(@PathVariable(name = "id") Long nCdConsulta)
	throws ResourceNotFoundException{
		ConsultaEntity consultaEntity = consultarepository.findById(nCdConsulta).orElseThrow( 
				() -> new ResourceNotFoundException("não foi possivél encontrar essa consulta com esse id"+ nCdConsulta));
		return ResponseEntity.ok().body(consultaEntity);
	}
	
	@PostMapping("/consulta")
	public ConsultaEntity createConsulta(@Valid @RequestBody ConsultaEntity consultaEntity) {
		return consultarepository.save(consultaEntity);
	}
	
	@PutMapping("/Consulta/{id}")
		public ResponseEntity<ConsultaEntity> updateConsulta(@PathVariable(value = "id") Long nCdConsulta, @Valid @RequestBody ConsultaEntity consultaDetalhes)throws ResourceNotFoundException
		{ ConsultaEntity consultaEntity = consultarepository.findById(nCdConsulta).orElseThrow(
				
		() -> new ResourceNotFoundException("Consulta não foi encontrada:" + nCdConsulta));
		
		consultaEntity.setnCdConsulta(consultaDetalhes.getnCdConsulta());
		consultaEntity.setcDecricao(consultaDetalhes.getcDecricao());
		consultaEntity.setnCdHorario(consultaDetalhes.getnCdHorario());
		consultaEntity.setnCdPaciente(consultaDetalhes.getnCdPaciente());
		consultaEntity.setnCdTpConsulta(consultaDetalhes.getnCdTpConsulta());
		consultaEntity.setdHoraInicial(consultaDetalhes.getdHoraInicial());
		consultaEntity.setdHoraFinal(consultaDetalhes.getdHoraFinal());
		consultaEntity.setnCdMedico(consultaDetalhes.getnCdMedico());
		consultaEntity.setnCdHospital(consultaDetalhes.getnCdHospital());
		final ConsultaEntity updateConsulta = consultarepository.save(consultaEntity);
		return ResponseEntity.ok(updateConsulta);
		}
	
	@DeleteMapping("/consulta/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long nCdConsulta)
	throws ResourceNotFoundException {
		ConsultaEntity consultaEntity = consultarepository.findById(nCdConsulta).orElseThrow(() -> 
		new ResourceNotFoundException("consulta não encontrada"+ nCdConsulta));
		
		consultarepository.delete(consultaEntity);
		Map<String,Boolean> reponse = new HashMap<>();		
		reponse.put("deleted", Boolean.TRUE);
		return reponse;
	}
}
