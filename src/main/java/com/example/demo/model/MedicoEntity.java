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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEDICO")
public class MedicoEntity {

	private long nCdMedico;
	private String cNmMedido;
	private String cCRM;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getnCdMedico() {
		return nCdMedico;
	}
	public void setnCdMedico(long nCdMedico) {
		this.nCdMedico = nCdMedico;
	}
	
	@Column(name="cNmMedido", nullable = false)
	public String getcNmMedido() {
		return cNmMedido;
	}
	public void setcNmMedido(String cNmMedido) {
		this.cNmMedido = cNmMedido;
	}
	
	@Column(name="cCRM", nullable = false)
	public String getcCRM() {
		return cCRM;
	}
	public void setcCRM(String cCRM) {
		this.cCRM = cCRM;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
					   })
	@JoinTable(name= "MEDICO_ESPECIALIDADE",
				joinColumns = {@JoinColumn(name = "nCdMedico")},
				inverseJoinColumns = {@JoinColumn(name= "nCdEspecialidade") })
	private Set<EspecialidadeEntity> especialidades = new HashSet<>();
	
	@OneToMany(mappedBy = "MedicoEntity", cascade = CascadeType.ALL)
	private Set<MedicoContatosEntity> medicoContatosEntity;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "MEDICO")
	private Set<HospitalEntity> hospitalentity = new HashSet<>();
		
	public MedicoEntity(long nCdMedico, String cNmMedido, String cCRM) {
		super();
		this.nCdMedico = nCdMedico;
		this.cNmMedido = cNmMedido;
		this.cCRM = cCRM;
	}

	MedicoEntity(){}
	@Override
	public String toString() {
		return "MedicoEntity [nCdMedico=" + nCdMedico + ", cNmMedido=" + cNmMedido + ", cCRM=" + cCRM + "]";
	}
	

	

	
}
