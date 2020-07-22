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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "ESPECIALIDADE")
public class EspecialidadeEntity {

	private long nCdEspecialidade;	
	private String cNmEspecialidade;	
	private String cDescricaoEspcialidade;
	
	@Id
	@Column(name = "nCdEspecialidade", nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getnCdEspecialidade() {
		return nCdEspecialidade;
	}
	public void setnCdEspecialidade(long nCdEspecialidade) {
		this.nCdEspecialidade = nCdEspecialidade;
	}
	
	@Column(name = "cNmEspecialidade", nullable = true)
	public String getcNmEspecialidade() {
		return cNmEspecialidade;
	}
	public void setcNmEspecialidade(String cNmEspecialidade) {
		this.cNmEspecialidade = cNmEspecialidade;
	}
	
	@Column(name = "cDescricaoEspcialidade", nullable = true)
	public String getcDescricaoEspcialidade() {
		return cDescricaoEspcialidade;
	}
	public void setcDescricaoEspcialidade(String cDescricaoEspcialidade) {
		this.cDescricaoEspcialidade = cDescricaoEspcialidade;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.PERSIST,
				CascadeType.MERGE},
				mappedBy = "ESPECIALIDADE")
	private Set<MedicoEntity> medico = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "ESPECIALIDADE")
		private Set<HospitalEntity> hospital = new HashSet<>();
	
	public EspecialidadeEntity(long nCdEspecialidade, String cNmEspecialidade, String cDescricaoEspcialidade) {
		super();
		this.nCdEspecialidade = nCdEspecialidade;
		this.cNmEspecialidade = cNmEspecialidade;
		this.cDescricaoEspcialidade = cDescricaoEspcialidade;
	}
	
	@Override
	public String toString() {
		return "EspecialidadeEntity [nCdEspecialidade=" + nCdEspecialidade + ", cNmEspecialidade=" + cNmEspecialidade
				+ ", cDescricaoEspcialidade=" + cDescricaoEspcialidade + "]";
	}
	
	
}
