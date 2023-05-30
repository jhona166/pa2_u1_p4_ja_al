package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService{
	
	
	@Autowired
	private CuentaRepository bancariaRepository;
	
	
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

	
	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//1. consultar la cuenta de origen por el numero de cuenta
		Cuenta ctaOrigen = this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
		
		//2. consultar el saldo de la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		//3. validar si el saldo es suficiente
		if(monto.compareTo(saldoOrigen)<=0) {
			
			//5. si es suficiente ir al paso 6
			//6. ralizamos la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen =  saldoOrigen.subtract(monto);
			//7. actualizamos el nuevo saldo de la ceunta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualiza(ctaOrigen);
			//8. Consultamos la cuenta de destino por el numero
			Cuenta ctaDestino = this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
			//9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			//10. realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino= saldoDestino.add(monto);
			//11. actualizamos el nuevo saldo de la cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualiza(ctaDestino);
			//12. creamos la transferencia
			Transferencia transfer = new Transferencia();
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setCuentaDestino(ctaDestino);
			transfer.setMonto(monto);
			Double numero = Math.random();
			transfer.setNumero(numero.toString());
			transfer.setFecha(LocalDate.now());
			this.transferenciaRepository.insertar(transfer);
		}else {
			
			//4. si no es suficiente imprimir mensaje de no hay saldo
			System.out.println("Saldo no disponible, su saldo es: " + saldoOrigen);
		}
		
		
		
	}
}
