package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HorariosEntity;
import com.example.demo.model.HorariosPk;
import com.example.demo.repository.HorariosRepository;



@RestController
@RequestMapping("/api/v1")
public class HorariosController {

	@Autowired
	private HorariosRepository horarioRepository;
	
	@GetMapping("/horarios")
	public List<HorariosEntity> getAllHorarios(){
		return horarioRepository.findAll();
	}
	
	@GetMapping("/horarios/{id}")
	public ResponseEntity<HorariosEntity> getHorariosById(@PathVariable(value = "id") HorariosPk horariopk)
	throws ResourceNotFoundException {
		HorariosEntity horarioEntity = horarioRepository.findById(horariopk).orElseThrow(() -> new ResourceNotFoundException("horario não encontrado com esse id:" + horariopk));
		return ResponseEntity.ok().body(horarioEntity);
	}
	
	@GetMapping("/horariosindisponiveis")
		public List<HorariosEntity> getdayIndisponiveis(){
		return HorariosRepository.dataIndisponiveisConsulta();
		}
	
//	@GetMapping("/horariosDeDataLivre/{data}")
//	public ResponseEntity<HorariosEntity> getHorariosByDay(@PathVariable(value = "day") )
//	throws ResourceNotFoundException {
	//	HorariosEntity horariosEntity = horarioRepository.GetHorarioByDayLivre().orelseThrow(() -> new ResourceNotFoundException("horarios escolhido não disponivél:" + horariosEntityum));
	//	return ResponseEntity.ok().body(horariosEntity);
	//}
}
