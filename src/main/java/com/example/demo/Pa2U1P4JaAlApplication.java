package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.CargaSistemaService;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.TransferenciaService;

@SpringBootApplication
public class Pa2U1P4JaAlApplication implements CommandLineRunner{
	@Autowired
	private Cajero cajero;
	
	@Autowired
	private Cajero cajero1;
	
	@Autowired
	private Presidente presidente;
	
	
	@Autowired
	private Presidente presidente1;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
	
	@Autowired
	private TransferenciaService transferenciaService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JaAlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	this.cajero.setApellido("Altamirano");
	this.cajero.setNombre("Jhonatan");
	this.cajero.setSalario(new BigDecimal(800));
	System.out.println(this.cajero);
	System.out.println(this.cajero1);
	
	
	System.out.println(this.cajero1.getApellido());
		
	
	this.presidente.setNombre("Grace");
	this.presidente.setApellido("Analuisa");
	this.presidente.setCedula("1727501511");

	this.presidente1.setApellido("Carvajal");
	
	System.out.println(this.presidente);
	System.out.println(this.presidente1);
	
	System.out.println("**********Segunda Parte*********");
	this.cargaSistemaService.cargar();
	Transferencia trans= new Transferencia();
	trans.setCuentaDestino(null);
	trans.setCuentaOrigen(null);
	trans.setFecha(LocalDate.now());
	trans.setMonto(new BigDecimal(100));
	trans.setNumero("1234");
	this.transferenciaService.guardar(trans);
	
	}

}
