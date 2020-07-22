package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_CONSULTA")
public class TipoConsultaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long nCdTpConsulta;
	
	@Column(name="cNmTpConsulta")
	private String cNmTpConsulta;
	
	@Column(name="cDescricao")
	private String cDescricao;
	
	@OneToMany(mappedBy = "nCdTpConsulta1", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<ConsultaEntity> sendTipoConsulta;
	
	

	public Long getnCdTpConsulta() {
		return nCdTpConsulta;
	}

	public void setnCdTpConsulta(Long nCdTpConsulta) {
		this.nCdTpConsulta = nCdTpConsulta;
	}

	public String getcNmTpConsulta() {
		return cNmTpConsulta;
	}

	public void setcNmTpConsulta(String cNmTpConsulta) {
		this.cNmTpConsulta = cNmTpConsulta;
	}

	public String getcDescricao() {
		return cDescricao;
	}

	public void setcDescricao(String cDescricao) {
		this.cDescricao = cDescricao;
	}

	public Set<ConsultaEntity> getConsultas() {
		return sendTipoConsulta;
	}

	public void setConsultas(Set<ConsultaEntity> sendTipoConsulta) {
		this.sendTipoConsulta = sendTipoConsulta;
	}

	public TipoConsultaEntity() {
	
	}

	public TipoConsultaEntity(Long nCdTpConsulta, String cNmTpConsulta, String cDescricao,
			Set<ConsultaEntity> sendTipoConsulta) {

		this.nCdTpConsulta = nCdTpConsulta;
		this.cNmTpConsulta = cNmTpConsulta;
		this.cDescricao = cDescricao;
		this.sendTipoConsulta = sendTipoConsulta;
	}

	@Override
	public String toString() {
		return "TipoConsultaEntity [nCdTpConsulta=" + nCdTpConsulta + ", cNmTpConsulta=" + cNmTpConsulta
				+ ", cDescricao=" + cDescricao + ", consultas=" + sendTipoConsulta + "]";
	}
	
}
