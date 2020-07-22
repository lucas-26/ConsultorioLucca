package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEDIDO_CONTATOS")
public class MedicoContatosEntity {
	
	@ManyToOne
	@JoinColumn
	private MedicoEntity nCdMedico;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long nCdContato;
	private String cContato;
	private String CTpContato;
	
	
	public MedicoEntity getnCdMedico() {
		return nCdMedico;
	}
	public void setnCdMedico(MedicoEntity nCdMedico) {
		this.nCdMedico = nCdMedico;
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
	public String getCTpContato() {
		return CTpContato;
	}
	public void setCTpContato(String cTpContato) {
		CTpContato = cTpContato;
	}
	public MedicoContatosEntity() {
		
	}
	public MedicoContatosEntity(MedicoEntity nCdMedico, Long nCdContato, String cContato, String cTpContato) {
		super();
		this.nCdMedico = nCdMedico;
		this.nCdContato = nCdContato;
		this.cContato = cContato;
		CTpContato = cTpContato;
	}
	@Override
	public String toString() {
		return "MedicoContatosEntity [nCdMedico=" + nCdMedico + ", nCdContato=" + nCdContato + ", cContato=" + cContato
				+ ", CTpContato=" + CTpContato + "]";
	}
	
	
	
}
