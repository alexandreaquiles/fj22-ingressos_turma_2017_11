package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaClientesDeBanco implements Desconto {

	@Override
	public BigDecimal aplicaDesconto(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal("0.7"));
	}

}
