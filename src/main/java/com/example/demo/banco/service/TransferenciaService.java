package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
	public void guardar(Transferencia transferencia);
	public void actualiza(Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia seleccionarPorNumero(String numero);
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto);
	public List<Transferencia> imprimirTodos();
}
