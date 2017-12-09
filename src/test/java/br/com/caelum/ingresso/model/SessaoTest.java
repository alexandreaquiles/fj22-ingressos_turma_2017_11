package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerASomaDoPrecoDaSalaComOPrecoDoFilme() {
		Sala sala = new Sala("Sala IMAX 1", BigDecimal.TEN);
		
		Duration duracao = Duration.ofMinutes(120);
		Filme filme = new Filme("Lagoa Azul", duracao, "Romance", BigDecimal.TEN);
		
		LocalTime horario = LocalTime.of(13, 0);

		Sessao nova = new Sessao(horario, filme, sala);
		
		Assert.assertEquals(new BigDecimal("20") , nova.getPreco());
	}

}
