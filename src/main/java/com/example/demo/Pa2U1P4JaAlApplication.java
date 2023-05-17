package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4JaAlApplication implements CommandLineRunner{
	
	@Autowired
	private Profesor profe2;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JaAlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		/*
		 * Spring framework: Framework que permite la construccion/desarrollo de 
		 * aplicaciones empresariales basadas en Spring
		 */
		
		Profesor profe =new Profesor();
		profe.setApellido("Altamirano");
		profe.setCedula("1727501510");
		profe.setFechaNacimiento(LocalDateTime.now());
		profe.setNombre("Jhonatan");
		System.out.println(profe);
		System.out.println(profe.getApellido());
		
	
		System.out.println(profe2);
		profe2.setApellido("Teran");
		
		System.out.println(profe2.getApellido());
		
		
		Profesor profe3 = new Profesor();
		profe3 = profe;
		System.out.println(profe3);
		profe.setApellido("Lopez");
		System.out.println(profe3);
		
		MatriculaCalculo mat = new MatriculaCalculo();
		mat.realizarMatricula("1");
	}

}
