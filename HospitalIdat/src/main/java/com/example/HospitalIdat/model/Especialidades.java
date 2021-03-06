package com.example.HospitalIdat.model;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Especialidad")
public class Especialidades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	private String especialidad;
	private Integer diasAtiende;
	
	@OneToMany(mappedBy = "Especialidad")
	private List<Recepcionista> recepcionista = new ArrayList<>();
	

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public Integer getDiasAtiende() {
		return diasAtiende;
	}
	public void setDiasAtiende(Integer diasAtiende) {
		this.diasAtiende = diasAtiende;
	}
	
	

	
}
