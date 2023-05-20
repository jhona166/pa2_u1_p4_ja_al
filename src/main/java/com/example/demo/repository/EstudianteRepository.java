package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	// Se busca a partir de un identificador o primary Key
	public Estudiante seleccionar(String cedula);

	// Eliminamos por identificador
	public void eliminar(Integer id);

}
