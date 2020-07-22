package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable 
public class HorariosPk implements Serializable{

		@Id
		private Long nCdHorario;
		@Id
		private Date dHoraInicial;
		@Id
		private Date dHoraFinal;
		
		@ManyToOne
		@JoinColumn(name = "nCdMedico")
		private MedicoEntity nCdMedico;

		@ManyToOne
		@JoinColumn(name = "nCdHospital")
		private HospitalEntity nCdHospital;

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

		public MedicoEntity getnCdMedico() {
			return nCdMedico;
		}

		public void setnCdMedico(MedicoEntity nCdMedico) {
			this.nCdMedico = nCdMedico;
		}

		public HospitalEntity getnCdHospital() {
			return nCdHospital;
		}

		public void setnCdHospital(HospitalEntity nCdHospital) {
			this.nCdHospital = nCdHospital;
		}

		public HorariosPk(Long nCdHorario, Date dHoraInicial, Date dHoraFinal, MedicoEntity nCdMedico,
				HospitalEntity nCdHospital) {
			super();
			this.nCdHorario = nCdHorario;
			this.dHoraInicial = dHoraInicial;
			this.dHoraFinal = dHoraFinal;
			this.nCdMedico = nCdMedico;
			this.nCdHospital = nCdHospital;
		}

		public HorariosPk() {
		
		}

}
