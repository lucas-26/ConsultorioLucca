package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONSULTA")
public class ConsultaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long nCdConsulta;
	@Column(name="cDecricao")
	private String cDecricao;
	
	
	@AttributeOverrides({
	@AttributeOverride(name="nCdHorario", column = @Column(name="nCdHorario")),
	@AttributeOverride(name="dHoraInicial", column = @Column(name="dHoraInicial")),
	@AttributeOverride(name="dHoraFinal", column = @Column(name="dHoraFinal")),
	@AttributeOverride(name="nCdMedico", column = @Column(name="nCdMedico")),
	@AttributeOverride(name="nCdHospital", column = @Column(name="nCdHospital")),
	})
	private Long nCdHorario;
	private Date dHoraInicial;
	private Date dHoraFinal;
	private Long nCdMedico;
	private Long nCdHospital;	
	
	
	@ManyToOne
	@JoinColumn
	private PacienteEntity nCdPaciente;
	
	@ManyToOne
	@JoinColumn(name = "nCdTpConsulta")
	private TipoConsultaEntity nCdTpConsulta1;
	

	public long getnCdConsulta() {
		return nCdConsulta;
	}



	public void setnCdConsulta(long nCdConsulta) {
		this.nCdConsulta = nCdConsulta;
	}



	public String getcDecricao() {
		return cDecricao;
	}



	public void setcDecricao(String cDecricao) {
		this.cDecricao = cDecricao;
	}



	public Long getnCdHorario() {
		return nCdHorario;
	}



	public void setnCdHorario(Long nCdHorario) {
		this.nCdHorario = nCdHorario;
	}



	public Date getdHoraInicial() {
		return dHoraInicial;
	}



	public void setdHoraInicial(Date dHoraInicial) {
		this.dHoraInicial = dHoraInicial;
	}



	public Date getdHoraFinal() {
		return dHoraFinal;
	}



	public void setdHoraFinal(Date dHoraFinal) {
		this.dHoraFinal = dHoraFinal;
	}



	public Long getnCdMedico() {
		return nCdMedico;
	}



	public void setnCdMedico(Long nCdMedico) {
		this.nCdMedico = nCdMedico;
	}



	public Long getnCdHospital() {
		return nCdHospital;
	}



	public void setnCdHospital(Long nCdHospital) {
		this.nCdHospital = nCdHospital;
	}



	public PacienteEntity getnCdPaciente() {
		return nCdPaciente;
	}



	public void setnCdPaciente(PacienteEntity nCdPaciente) {
		this.nCdPaciente = nCdPaciente;
	}



	public TipoConsultaEntity getnCdTpConsulta() {
		return nCdTpConsulta1;
	}



	public void setnCdTpConsulta(TipoConsultaEntity nCdTpConsulta) {
		this.nCdTpConsulta1 = nCdTpConsulta;
	}



	public TipoConsultaEntity getnCdTpConsulta1() {
		return nCdTpConsulta1;
	}



	public void setnCdTpConsulta1(TipoConsultaEntity nCdTpConsulta1) {
		this.nCdTpConsulta1 = nCdTpConsulta1;
	}



	public ConsultaEntity(long nCdConsulta, String cDecricao, Long nCdHorario, Date dHoraInicial, Date dHoraFinal,
			Long nCdMedico, Long nCdHospital, PacienteEntity nCdPaciente, TipoConsultaEntity nCdTpConsulta1) {
	
		this.nCdConsulta = nCdConsulta;
		this.cDecricao = cDecricao;
		this.nCdHorario = nCdHorario;
		this.dHoraInicial = dHoraInicial;
		this.dHoraFinal = dHoraFinal;
		this.nCdMedico = nCdMedico;
		this.nCdHospital = nCdHospital;
		this.nCdPaciente = nCdPaciente;
		this.nCdTpConsulta1 = nCdTpConsulta1;
	}

	public ConsultaEntity() {
		
	}



	@Override
	public String toString() {
		return "ConsultaEntity [nCdConsulta=" + nCdConsulta + ", cDecricao=" + cDecricao + ", nCdHorario=" + nCdHorario
				+ ", dHoraInicial=" + dHoraInicial + ", dHoraFinal=" + dHoraFinal + ", nCdMedico=" + nCdMedico
				+ ", nCdHospital=" + nCdHospital + ", nCdPaciente=" + nCdPaciente + ", nCdTpConsulta1=" + nCdTpConsulta1
				+ "]";
	}
	
	
}