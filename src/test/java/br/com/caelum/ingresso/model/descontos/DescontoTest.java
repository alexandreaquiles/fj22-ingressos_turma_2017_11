package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoTest {

	private Sessao sessao;
	
	@Before
	public void criaSessao() {
		BigDecimal precoSala = new BigDecimal("20.5");
		Sala sala = new Sala("IMAX", precoSala);
		
		Duration duracao = Duration.ofMinutes(120);
		BigDecimal precoFilme = new BigDecimal("12");
		Filme filme = new Filme("Rogue One", duracao , "Sci-fi", precoFilme);
		
		LocalTime horario = LocalTime.now();
		
		sessao = new Sessao(horario, filme, sala);
	}
	
	@Test
	public void deveConcederDescontoParaClientesDeBanco() {
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaClientesDeBanco());
		BigDecimal precoEsperado = new BigDecimal("22.75");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void deveConcederDescontoParaEstudantes() {
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaEstudantes());
		BigDecimal precoEsperado = new BigDecimal("16.25");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		BigDecimal precoEsperado = new BigDecimal("32.5");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
