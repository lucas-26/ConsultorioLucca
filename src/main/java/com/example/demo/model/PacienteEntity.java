package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "PACIENTE")
public class PacienteEntity {
	
	private long nCdPaciente;
	private long nCPF;
	private String cNmPaciente;
	private String dNascimento;
	private String dCadastro;
	private String cRG;
	private String cNaturalidade;
	
	public PacienteEntity() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getnCdPaciente() {
		return nCdPaciente;
	}
	public void setnCdPaciente(long nCdPaciente) {
		this.nCdPaciente = nCdPaciente;
	}
	
	@NotNull
	@Column(name= "nCPF", nullable = false)
	public long getnCPF() {
		return nCPF;
	}
	public void setnCPF(long nCPF) {
		this.nCPF = nCPF;
	}
	
	@NotNull
	@Column(name= "cNmPaciente", nullable = false)
	public String getcNmPaciente() {
		return cNmPaciente;
	}
	public void setcNmPaciente(String cNmPaciente) {
		this.cNmPaciente = cNmPaciente;
	}
	
	@NotNull
	@Column(name= "dNascimento", nullable = false)
	public String getdNascimento() {
		return dNascimento;
	}
	public void setdNascimento(String dNascimento) {
		this.dNascimento = dNascimento;
	}
	
	@NotNull
	@Column(name= "dCadastro", nullable = false)
	public String getdCadastro() {
		return dCadastro;
	}
	public void setdCadastro(String dCadastro) {
		this.dCadastro = dCadastro;
	}
	
	@NotNull
	@Column(name= "cRG", nullable = false)
	public String getcRG() {
		return cRG;
	}
	public void setcRG(String cRG) {
		this.cRG = cRG;
	}
	
	@NotNull
	@Column(name= "cNaturalidade", nullable = false)
	public String getcNaturalidade() {
		return cNaturalidade;
	}
	public void setcNaturalidade(String cNaturalidade) {
		this.cNaturalidade = cNaturalidade;
	}
	
	@OneToMany(mappedBy = "PacienteEntity", cascade = CascadeType.ALL)
	private Set<PacientesContatosEntity> pacienteContatosEntity;
	
	@OneToMany(mappedBy = "PacienteEntity", cascade = CascadeType.ALL)
	private Set<ConsultaEntity> consulta;
	public PacienteEntity(long nCdPaciente, long nCPF, String cNmPaciente, String dNascimento, String dCadastro,
			String cRG, String cNaturalidade) {
		this.nCdPaciente = nCdPaciente;
		this.nCPF = nCPF;
		this.cNmPaciente = cNmPaciente;
		this.dNascimento = dNascimento;
		this.dCadastro = dCadastro;
		this.cRG = cRG;
		this.cNaturalidade = cNaturalidade;
	}
	@Override
	public String toString() {
		return "PacienteEntity [nCdPaciente=" + nCdPaciente + ", nCPF=" + nCPF + ", cNmPaciente=" + cNmPaciente
				+ ", dNascimento=" + dNascimento + ", dCadastro=" + dCadastro + ", cRG=" + cRG + ", cNaturalidade="
				+ cNaturalidade + "]";
	}
	
	
	
}
