package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private LocalDateTime fecha;
	private LocalDateTime fechaNacimiento;
	
	
	//Set and Get
	
	public String getNombre() {
		return nombre;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", fecha=" + fecha
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	

	
}
