package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@Autowired 
	@Qualifier("internacional")
	private MontoDebitarService debitarService;
	
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
		Cuenta ctaOrigen = this.bancariaRepository.seleccionarPorNumero(numeroCtaOrigen);
		
		//2. consultar el saldo de la cuenta origen
		BigDecimal saldoCtaOrigen = ctaOrigen.getSaldo();
		BigDecimal montoDebitar = this.debitarService.calcular(monto); 
		//3. validar si el saldo es suficiente
		if(montoDebitar.compareTo(saldoCtaOrigen)<=0) {
			
			//5. si es suficiente ir al paso 6
			//6. ralizamos la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen =  saldoCtaOrigen.subtract(montoDebitar);
			//7. actualizamos el nuevo saldo de la ceunta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualiza(ctaOrigen);
			//8. Consultamos la cuenta de destino por el numero
			Cuenta ctaDestino = this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
			//9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoCtaDestino = ctaDestino.getSaldo();
			//10. realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino= saldoCtaDestino.add(monto);
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
			System.out.println("Saldo no disponible, su saldo es: " +saldoCtaOrigen );
		}
		
		
		
	}

	@Override
	public List<Transferencia> imprimirTodos() {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.imprimirTodos();
	}
}
