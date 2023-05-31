package com.example.demo.banco.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service("nacional")
public class MontoDebitarNacionalServiceImpl implements MontoDebitarService{

	@Override
	public BigDecimal calcular(BigDecimal monto) {
		// TODO Auto-generated method stub
		//BigDecimal comision = monto.multiply(new BigDecimal(0.1));
		
		return monto;
	}

}
