package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class PaisEntity {
	
	private long nCdPais;
	private String cNmPais;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nCdPais")
	public long getnCdPais() {
		return nCdPais;
	}
	public void setnCdPais(long nCdPais) {
		this.nCdPais = nCdPais;
	}
	
	@Column(name = "cNmPais")
	public String getcNmPais() {
		return cNmPais;
	}
	public void setcNmPais(String cNmPais) {
		this.cNmPais = cNmPais;
	}
	
	@OneToMany(mappedBy = "PaisEntity", cascade = CascadeType.ALL)
	private Set<UfEntity> uf;
	
	public PaisEntity(long nCdPais, String cNmPais) {
		super();
		this.nCdPais = nCdPais;
		this.cNmPais = cNmPais;
	}
	public PaisEntity(){}
	
	@Override
	public String toString() {
		return "PaisEntity [nCdPais=" + nCdPais + ", cNmPais=" + cNmPais + "]";
	}

}
