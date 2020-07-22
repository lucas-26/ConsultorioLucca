package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.HorariosEntity;
import com.example.demo.model.HorariosPk;

public interface HorariosRepository extends JpaRepository<HorariosEntity, HorariosPk>{
	@Query(value = "SELECT DATA_INICIAL = CONVERT(VARCHAR(11),HORARIOS.dHoraInicial,103)\r\n" + 
			"      ,DATA_FINAL   = CONVERT(VARCHAR(11),HORARIOS.dHoraFinal,103)\r\n" + 
			" FROM HORARIOS WITH(NOLOCK)\r\n" + 
			"WHERE HORARIOS.dHoraInicial >= GETDATE()\r\n" + 
			"  AND (\r\n" + 
			"         EXISTS(SELECT 1\r\n" + 
			"                     FROM CONSULTA WITH(NOLOCK)\r\n" + 
			"                   WHERE CONSULTA.nCdHorario = HORARIOS.nCdHorario\r\n" + 
			"               )\r\n" + 
			"      OR EXISTS(SELECT 1\r\n" + 
			"                      FROM EXAME WITH(NOLOCK)\r\n" + 
			"                     WHERE EXAME.nCdHorario = HORARIOS.nCdHorario\r\n" + 
			"               )\r\n" + 
			"      ) ", nativeQuery = true)
	static
	List<HorariosEntity> dataIndisponiveisConsulta() {
		// TODO Auto-generated method stub
		return null;
	}
	;
		

}
