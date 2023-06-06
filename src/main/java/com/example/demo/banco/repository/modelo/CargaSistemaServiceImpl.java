package com.example.demo.banco.repository.modelo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Impuesto;
import com.example.demo.banco.repository.ImpuestoRepository;

@Service
public class CargaSistemaServiceImpl implements CargaSistemaService{
	@Autowired
	private Impuesto impuesto;
	
	@Autowired
	private ImpuestoRepository impuestoRepository;
	
	
	
	@Override
	public void cargar() {
		// TODO Auto-generated method stub
	BigDecimal valorIva = this.impuestoRepository.seleccionar("IVA");	
	this.impuesto.setIva(valorIva);
	System.out.println("Fin de carga de impuestos");
	}

}
