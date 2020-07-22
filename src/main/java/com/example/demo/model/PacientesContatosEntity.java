package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTES_CONTATOS")
public class PacientesContatosEntity {
	
	@ManyToOne
	@JoinColumn
	private PacienteEntity nCdPaciente;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long nCdContato;
	
	@Column(name = "cContato")
	private String cContato;
	@Column(name = "cTpContato")
	private String cTpContato;
	public PacienteEntity getnCdPaciente() {
		return nCdPaciente;
	}
	public void setnCdPaciente(PacienteEntity nCdPaciente) {
		this.nCdPaciente = nCdPaciente;
	}
	public Long getnCdContato() {
		return nCdContato;
	}
	public void setnCdContato(Long nCdContato) {
		this.nCdContato = nCdContato;
	}
	public String getcContato() {
		return cContato;
	}
	public void setcContato(String cContato) {
		this.cContato = cContato;
	}
	public String getcTpContato() {
		return cTpContato;
	}
	public void setcTpContato(String cTpContato) {
		this.cTpContato = cTpContato;
	}
	public PacientesContatosEntity() {

	}
	public PacientesContatosEntity(PacienteEntity nCdPaciente, Long nCdContato, String cContato, String cTpContato) {
		
		this.nCdPaciente = nCdPaciente;
		this.nCdContato = nCdContato;
		this.cContato = cContato;
		this.cTpContato = cTpContato;
	}
	@Override
	public String toString() {
		return "PacientesContatosEntity [nCdPaciente=" + nCdPaciente + ", nCdContato=" + nCdContato + ", cContato="
				+ cContato + ", cTpContato=" + cTpContato + "]";
	}
	
	
}
