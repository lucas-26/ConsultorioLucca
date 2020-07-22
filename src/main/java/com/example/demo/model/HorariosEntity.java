package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity 
@Table(name="HORARIOS")
@IdClass(HorariosPk.class)
public class HorariosEntity {
	
	
	HorariosEntity(){
	}
	
	HorariosEntity(HorariosPk horariospk){
		nCdHorario =  horariospk.getnCdHorario();
		dHoraInicial = horariospk.getdHoraInicial();
		dHoraFinal = horariospk.getdHoraFinal();
		nCdHospital = horariospk.getnCdHospital();
		nCdMedico = horariospk.getnCdMedico();
	}
	
	@Id
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
	private HospitalEntity nCdHospital;
	private MedicoEntity nCdMedico;
	
	
	@OneToMany(mappedBy = "horarios", cascade = CascadeType.ALL)
	private Set<ExameEntity> setExame;
	
	
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

	public HospitalEntity getnCdHospital() {
		return nCdHospital;
	}

	public void setnCdHospital(HospitalEntity nCdHospital) {
		this.nCdHospital = nCdHospital;
	}

	public MedicoEntity getnCdMedico() {
		return nCdMedico;
	}

	public void setnCdMedico(MedicoEntity nCdMedico) {
		this.nCdMedico = nCdMedico;
	}


	public HorariosEntity(Long nCdHorario, Date dHoraInicial, Date dHoraFinal, HospitalEntity nCdHospital,
			MedicoEntity nCdMedico) {
		super();
		this.nCdHorario = nCdHorario;
		this.dHoraInicial = dHoraInicial;
		this.dHoraFinal = dHoraFinal;
		this.nCdHospital = nCdHospital;
		this.nCdMedico = nCdMedico;
	}

	@Override
	public String toString() {
		return "HorariosEntity [nCdHorario=" + nCdHorario + ", dHoraInicial=" + dHoraInicial + ", dHoraFinal="
				+ dHoraFinal + ", nCdHospital=" + nCdHospital + ", nCdMedico=" + nCdMedico + ", setExame=" + setExame
				+ "]";
	}

	
	
}
