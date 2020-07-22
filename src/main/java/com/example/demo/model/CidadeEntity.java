package com.example.demo.model;


import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "CIDADE")
public class CidadeEntity {

	private long nCdCidade;
	private String cNmCidade;
	private UfEntity nCdUF;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nCdCidade",nullable = true)
	public long getnCdCidade() {
		return nCdCidade;
	}
	public void setnCdCidade(long nCdCidade) {
		this.nCdCidade = nCdCidade;
	}
	
	@Column(name = "cNmCidade",nullable = true)
	public String getcNmCidade() {
		return cNmCidade;
	}
	public void setcNmCidade(String cNmCidade) {
		this.cNmCidade = cNmCidade;
	}
	
	@ManyToOne
	@JoinColumn(name = "nCdUF", nullable = true)
	public UfEntity getnCdUF() {
		return nCdUF;
	}
	public void setnCdUF(UfEntity nCdUF) {
		this.nCdUF = nCdUF;
	}
	
	public CidadeEntity() {}

	public CidadeEntity(long nCdCidade, String cNmCidade, UfEntity nCdUF) {
		super();
		this.nCdCidade = nCdCidade;
		this.cNmCidade = cNmCidade;
		this.nCdUF = nCdUF;
	}
	
	@OneToMany(mappedBy = "cidadeEntity", cascade = CascadeType.ALL)
	private Set<HospitalEntity> HospitalEntity;

	@Override
	public String toString() {
		return "CidadeEntity [nCdCidade=" + nCdCidade + ", cNmCidade=" + cNmCidade + ", nCdUF=" + nCdUF + "]";
	}
	

}