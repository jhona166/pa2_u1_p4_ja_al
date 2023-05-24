package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Transferencia;

public class TransferenciaServiceImpl implements TransferenciaService{
	
	@Autowired
	private TransferenciaRepository transferenciaRepository; 
	@Override
	public void guardar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualiza(Transferencia transferencia) {
		this.transferenciaRepository.actualiza(transferencia);
	}

	@Override
	public void borrar(String numero) {
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public Transferencia seleccionarPorNumero(String numero) {
		return this.seleccionarPorNumero(numero);
	}

}
