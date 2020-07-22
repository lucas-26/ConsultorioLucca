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
@Table(name = "TIPO_EXAME")
public class TipoExameEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nCdTpExame", nullable = true)
	private Long nCdTpExame;
	
	@Column(name = "cNmTpExame")
	private String cNmTpExame;
	
	@Column(name = "cDescricao")
	private String cDescricao;
	
	public Long getnCdTpExame() {
		return nCdTpExame;
	}

	public void setnCdTpExame(Long nCdTpExame) {
		this.nCdTpExame = nCdTpExame;
	}

	public String getcNmTpExame() {
		return cNmTpExame;
	}

	public void setcNmTpExame(String cNmTpExame) {
		this.cNmTpExame = cNmTpExame;
	}

	public String getcDescricao() {
		return cDescricao;
	}

	public void setcDescricao(String cDescricao) {
		this.cDescricao = cDescricao;
	}

	public TipoExameEntity() {	}

	public TipoExameEntity(Long nCdTpExame, String cNmTpExame, String cDescricao) {
		super();
		this.nCdTpExame = nCdTpExame;
		this.cNmTpExame = cNmTpExame;
		this.cDescricao = cDescricao;
	}

	@Override
	public String toString() {
		return "TipoExameEntity [nCdTpExame=" + nCdTpExame + ", cNmTpExame=" + cNmTpExame + ", cDescricao=" + cDescricao
				+ "]";
	}
	
	
}


