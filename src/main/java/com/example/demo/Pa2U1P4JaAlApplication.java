package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4JaAlApplication implements CommandLineRunner{
	@Autowired
	private EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JaAlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		
		Estudiante miEstudiante = new Estudiante();
		miEstudiante.setApellido("Altamirano");
		miEstudiante.setCedula("1727501510");
		miEstudiante.setNombre("Jhonatan");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(2000,03,16,10,50));
		
		//1.Guardar 
		this.estudianteService.guardar(miEstudiante);
		
		
		Estudiante miEstudiante2 = new Estudiante();
		miEstudiante2.setApellido("Ortega");
		miEstudiante2.setCedula("1727501511");
		miEstudiante2.setNombre("Jimmy");
		miEstudiante2.setFechaNacimiento(LocalDateTime.of(2001,03,16,10,50));
		
		//1.Guardar 
	
		this.estudianteService.guardar(miEstudiante2);
		
		
		
		//5.Imprimir reporte1
		List<Estudiante> reporte = this.estudianteService.reporteTodos();
		System.out.println("Reporte de todos los estudiantes");
		for(Estudiante estu:reporte)
		{
			System.out.println(estu);
		}
		
		//2.Actualizar
		miEstudiante.setApellido("Guaynalla");
		this.estudianteService.actualizar(miEstudiante);

		// 5.Imprimir reporte2
		List<Estudiante> reporte2 = this.estudianteService.reporteTodos();
		System.out.println("Reporte 2 de todos los estudiantes");
		for (Estudiante estu : reporte2) {
			System.out.println(estu);
		}
		
		
		//3.Eliminar
		this.estudianteService.borrar("1727501510");
	
		// 5.Imprimir reporte3  Elimina Estudiante
		List<Estudiante> reporte3 = this.estudianteService.reporteTodos();
		System.out.println("Reporte 3 de todos los estudiantes");
		for (Estudiante estu : reporte3) {
			System.out.println(estu);
		}
		
		//Busqueda del ultimo estudiante
		System.out.println("Adicional");
		System.out.println(this.estudianteService.buscarPorCedula("1727501511"));
		//Busqueda de una cedula que no existe
		System.out.println(this.estudianteService.buscarPorCedula("1727501513"));
		
		
	}

}
