package com.example.demo.banco.service;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
	public void guardar(Transferencia transferencia);
	public void actualiza(Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia seleccionarPorNumero(String numero);
}
