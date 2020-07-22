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
@Table(name = "UF")
public class UfEntity {
	private long nCdUF;
	private String cNmUF;
	private String cSiglaUF;
	private PaisEntity nCdPais;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nCdUF")
	public long getnCdUF() {
		return nCdUF;
	}
	public void setnCdUF(long nCdUF) {
		this.nCdUF = nCdUF;
	}
	@Column(name = "cNmUF", nullable = true)
	public String getcNmUF() {
		return cNmUF;
	}
	public void setcNmUF(String cNmUF) {
		this.cNmUF = cNmUF;
	}
	@Column(name = "cSiglaUF", nullable = true)
	public String getcSiglaUF() {
		return cSiglaUF;
	}
	public void setcSiglaUF(String cSiglaUF) {
		this.cSiglaUF = cSiglaUF;
	}
	
	@ManyToOne
	@JoinColumn(name = "nCdPais", nullable = true)
	public PaisEntity getnCdPais() {
		return nCdPais;
	}
	public void setnCdPais(PaisEntity nCdPais) {
		this.nCdPais = nCdPais;
	}
	public UfEntity() {}
	
	public UfEntity(long nCdUF, String cNmUF, String cSiglaUF, PaisEntity nCdPais) {
		super();
		this.nCdUF = nCdUF;
		this.cNmUF = cNmUF;
		this.cSiglaUF = cSiglaUF;
		this.nCdPais = nCdPais;
	}
	
	@Override
	public String toString() {
		return "UfEntity [nCdUF=" + nCdUF + ", cNmUF=" + cNmUF + ", cSiglaUF=" + cSiglaUF + ", nCdPais=" + nCdPais
				+ "]";
	}
	
}
