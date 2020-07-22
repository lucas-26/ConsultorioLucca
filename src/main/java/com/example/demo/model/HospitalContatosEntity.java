package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HOSPITAL_CONTATOS")
public class HospitalContatosEntity {
	
	@ManyToOne
	@JoinColumn(name = "nCdHospital")
	private HospitalEntity nCdHospital;
	
	@Id
	@Column(name="nCdContato")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nCdContato;
	@Column(name = "cContato")
	private String  cContato;
	@Column(name = "TpContato")
	private String TpContato;
	
	
	public HospitalEntity getnCdHospital() {
		return nCdHospital;
	}
	public void setnCdHospital(HospitalEntity nCdHospital) {
		this.nCdHospital = nCdHospital;
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
	public String getTpContato() {
		return TpContato;
	}
	public void setTpContato(String tpContato) {
		TpContato = tpContato;
	}
	public HospitalContatosEntity() {
		
	}
	public HospitalContatosEntity(HospitalEntity nCdHospital, Long nCdContato, String cContato, String tpContato) {
		super();
		this.nCdHospital = nCdHospital;
		this.nCdContato = nCdContato;
		this.cContato = cContato;
		TpContato = tpContato;
	}
	@Override
	public String toString() {
		return "HospitalContatosEntity [nCdHospital=" + nCdHospital + ", nCdContato=" + nCdContato + ", cContato="
				+ cContato + ", TpContato=" + TpContato + "]";
	}
	
	
	
}
