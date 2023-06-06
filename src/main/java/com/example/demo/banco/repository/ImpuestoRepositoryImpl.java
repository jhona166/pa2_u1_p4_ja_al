package com.example.demo.banco.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Transferencia;

@Repository
public class ImpuestoRepositoryImpl implements ImpuestoRepository{
	private static List<Transferencia> baseDatos = new ArrayList<>();
	@Override
	public BigDecimal seleccionar(String codigoImpuesto) {
		// TODO Auto-generated method stub
		return new BigDecimal(12);
	}
	
	
	
}
