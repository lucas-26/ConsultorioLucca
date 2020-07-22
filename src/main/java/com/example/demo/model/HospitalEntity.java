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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HOSPITAL")
public class HospitalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="nCdHospital", nullable = true)
	private Long nCdHospital;	
	private String cNmHospital;	
	private String cEndereco;	
	private String cCEP;	
	private String cNumeroEndereco;
	private String cReferencia;	
	
	@ManyToOne
	@JoinColumn(name = "nCdCidade")
	private CidadeEntity nCdCidade;
	
	
	public Long getnCdHospital() {
		return nCdHospital;
	}
	public void setnCdHospital(Long nCdHospital) {
		this.nCdHospital = nCdHospital;
	}
	
	
	@Column(name="cNmHospital")
	public String getcNmHospital() {
		return cNmHospital;
	}
	public void setcNmHospital(String cNmHospital) {
		this.cNmHospital = cNmHospital;
	}
	
	@Column(name="cEndereco")
	public String getcEndereco() {
		return cEndereco;
	}
	public void setcEndereco(String cEndereco) {
		this.cEndereco = cEndereco;
	}
	
	@Column(name="cCEP")
	public String getcCEP() {
		return cCEP;
	}
	public void setcCEP(String cCEP) {
		this.cCEP = cCEP;
	}
	
	@Column(name="cNumeroEndereco")
	public String getcNumeroEndereco() {
		return cNumeroEndereco;
	}
	public void setcNumeroEndereco(String cNumeroEndereco) {
		this.cNumeroEndereco = cNumeroEndereco;
	}
	
	@Column(name="cReferencia")
	public String getcReferencia() {
		return cReferencia;
	}
	public void setcReferencia(String cReferencia) {
		this.cReferencia = cReferencia;
	}
	

	public CidadeEntity getnCdCidade() {
		return nCdCidade;
	}
	public void setnCdCidade(CidadeEntity nCdCidade) {
		this.nCdCidade = nCdCidade;
	}
	
	@OneToMany(mappedBy = "nCdHospital", cascade = CascadeType.ALL)
	private Set<HospitalContatosEntity> hospitalContatoEntity;
		
	@ManyToMany(fetch = FetchType.LAZY,
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name="HOSPITAL_ESPECIALIDADE",
	joinColumns = {@JoinColumn(name = "nCdEspecialidade")},
	inverseJoinColumns = { @JoinColumn(name = "nCdHospital")})
	private Set<EspecialidadeEntity> especialidadeHospital = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "HOSPITAL_MEDICO",
	
		joinColumns = {@JoinColumn(name = "nCdHospital")},
		inverseJoinColumns = {@JoinColumn(name = "nCdMedico")})
	private Set<MedicoEntity> medicoEntity = new HashSet<>();
		
	public HospitalEntity() {}
	public HospitalEntity(Long nCdHospital, String cNmHospital, String cEndereco, String cCEP, String cNumeroEndereco,
			String cReferencia, CidadeEntity nCdCidade) {
		super();
		this.nCdHospital = nCdHospital;
		this.cNmHospital = cNmHospital;
		this.cEndereco = cEndereco;
		this.cCEP = cCEP;
		this.cNumeroEndereco = cNumeroEndereco;
		this.cReferencia = cReferencia;
		this.nCdCidade = nCdCidade;
	}
	@Override
	public String toString() {
		return "HospitalEntity [nCdHospital=" + nCdHospital + ", cNmHospital=" + cNmHospital + ", cEndereco="
				+ cEndereco + ", cCEP=" + cCEP + ", cNumeroEndereco=" + cNumeroEndereco + ", cReferencia=" + cReferencia
				+ ", nCdCidade=" + nCdCidade + "]";
	}
	
	
		
}
