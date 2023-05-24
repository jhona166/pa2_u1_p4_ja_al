package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Cuenta;
@Repository
public class CuentaRepositoryImpl implements CuentaRepository{


	private static List<Cuenta> baseDatos = new ArrayList<>();
	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		baseDatos.add(cuenta);
	}

	@Override
	public void actualiza(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuenta = this.seleccionarPorNumero(numero);
		baseDatos.remove(cuenta);
	}

	@Override
	public Cuenta seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuentaEncontrado= new Cuenta();
		
		for(Cuenta  cuenta:baseDatos) {
			if(numero.equals(cuenta.getNumero())) {
				cuentaEncontrado = cuenta;
			}else {
				
			}
		}
		return cuentaEncontrado;
	}

}
