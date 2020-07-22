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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="EXAME")
public class ExameEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nCdExame", nullable = true)
	private Long nCdExame;
	
	@Column(name = "cDecricao")
	private String cDecricao;	
	
	@ManyToOne
	private HorariosEntity horarios;
	
	@ManyToOne
	@JoinColumn(name = "nCdPaciente")
	private PacienteEntity nCdPaciente;
	
	@ManyToOne
	@JoinColumn(name = "nCdTpExame")
	private TipoExameEntity nCdTpExame;
	

	
	ExameEntity(){
	}
	
	ExameEntity(HorariosPk horariospk){
		nCdHorario =  horariospk.getnCdHorario();
		dHoraInicial = horariospk.getdHoraInicial();
		dHoraFinal = horariospk.getdHoraFinal();
		nCdHospital = horariospk.getnCdHospital();
		nCdMedico = horariospk.getnCdMedico();
	}
		
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
	@ManyToOne
	@JoinColumn(name = "nCdHospital")
	private HospitalEntity nCdHospital;
	@ManyToOne
	@JoinColumn(name = "nCdMedico")
	private MedicoEntity nCdMedico;



	public Long getnCdExame() {
		return nCdExame;
	}

	public void setnCdExame(Long nCdExame) {
		this.nCdExame = nCdExame;
	}

	public String getcDecricao() {
		return cDecricao;
	}

	public void setcDecricao(String cDecricao) {
		this.cDecricao = cDecricao;
	}

	public HorariosEntity getHorarios() {
		return horarios;
	}

	public void setHorarios(HorariosEntity horarios) {
		this.horarios = horarios;
	}

	public PacienteEntity getnCdPaciente() {
		return nCdPaciente;
	}

	public void setnCdPaciente(PacienteEntity nCdPaciente) {
		this.nCdPaciente = nCdPaciente;
	}

	public TipoExameEntity getnCdTpExame() {
		return nCdTpExame;
	}

	public void setnCdTpExame(TipoExameEntity nCdTpExame) {
		this.nCdTpExame = nCdTpExame;
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

	public ExameEntity(Long nCdExame, String cDecricao, HorariosEntity horarios, PacienteEntity nCdPaciente,
			TipoExameEntity nCdTpExame, Long nCdHorario, Date dHoraInicial, Date dHoraFinal, HospitalEntity nCdHospital,
			MedicoEntity nCdMedico) {
		super();
		this.nCdExame = nCdExame;
		this.cDecricao = cDecricao;
		this.horarios = horarios;
		this.nCdPaciente = nCdPaciente;
		this.nCdTpExame = nCdTpExame;
		this.nCdHorario = nCdHorario;
		this.dHoraInicial = dHoraInicial;
		this.dHoraFinal = dHoraFinal;
		this.nCdHospital = nCdHospital;
		this.nCdMedico = nCdMedico;
	}

	@Override
	public String toString() {
		return "ExameEntity [nCdExame=" + nCdExame + ", cDecricao=" + cDecricao + ", horarios=" + horarios
				+ ", nCdPaciente=" + nCdPaciente + ", nCdTpExame=" + nCdTpExame + ", nCdHorario=" + nCdHorario
				+ ", dHoraInicial=" + dHoraInicial + ", dHoraFinal=" + dHoraFinal + ", nCdHospital=" + nCdHospital
				+ ", nCdMedico=" + nCdMedico + "]";
	}
	
}
