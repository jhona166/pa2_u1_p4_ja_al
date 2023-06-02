package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4JaAlApplication implements CommandLineRunner{
	@Autowired
	private TransferenciaService transferenciaService;
	@Autowired
	private CuentaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JaAlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//cta1
			Cuenta cta1= new Cuenta();
			cta1.setCedulaPropietario("1727501510");
			cta1.setFechaApertura(LocalDate.now());
			cta1.setNumero("12354");
			cta1.setSaldo(new BigDecimal(200));
			cta1.setTipo("A");
			this.bancariaService.guardar(cta1);

			//cta 2
			Cuenta cta2= new Cuenta();
			cta2.setCedulaPropietario("1727501511");
			cta2.setFechaApertura(LocalDate.of(2015, 10, 10));
			cta2.setNumero("321");
			cta2.setSaldo(new BigDecimal(100));
			cta2.setTipo("A");
			this.bancariaService.guardar(cta2);

			this.transferenciaService.realizar(cta1.getNumero(), cta2.getNumero(), new BigDecimal(10));

			System.out.println("saldo origen " + this.bancariaService.seleccionarPorNumero(cta1.getNumero()).getSaldo());
			System.out.println("saldo destino " + this.bancariaService.seleccionarPorNumero(cta2.getNumero()).getSaldo());
			
			System.out.println("Imprimir todos");
			System.out.println(this.transferenciaService.imprimirTodos());
			
	}

}
