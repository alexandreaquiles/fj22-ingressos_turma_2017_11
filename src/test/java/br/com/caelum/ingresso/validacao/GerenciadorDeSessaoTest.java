package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {
	
	@Test
	public void naoDevePermitirSessaoIniciandoNoMesmoHorarioDeUmaJaExistente () {
		
		//ARRANGE - criar os objetos

		LocalTime as11 = LocalTime.of(11, 0);
		
		Duration baixa = Duration.ofMinutes(116);
		Filme deVoltaParaOFuturo = new Filme("Back To The Future", baixa, "Aventura");
		
		Sala sala1 = new Sala("Sala 1");

		Sessao sessaoExistente = new Sessao(as11, deVoltaParaOFuturo, sala1);
		
		List<Sessao> existentes = new ArrayList<>();
		existentes.add(sessaoExistente);

		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(existentes);
		
		LocalTime as11DeNovo = LocalTime.of(11, 0);

		Duration media = Duration.ofMinutes(120);
		Filme terminator = new Filme("The Terminator", media, "Ação");

		Sessao nova = new Sessao(as11DeNovo, terminator, sala1);
		
		//ACT - chamar o método a ser testado
		boolean cabe = gerenciador.cabe(nova);
		
		//ASSERT - verificar o resultado
		//Assert.assertEquals(false, cabe);
		//Assert.assertFalse(cabe);
		Assert.assertFalse("Não deveria caber ...", cabe);
	}
	
	@Test
	public void naoDevePermitirSessaoIniciandoNoMeioDeUmaJaExistente () {
		LocalTime as11 = LocalTime.of(11, 0);
		
		Duration baixa = Duration.ofMinutes(116);
		Filme deVoltaParaOFuturo = new Filme("Back To The Future", baixa, "Aventura");
		
		Sala sala1 = new Sala("Sala 1");

		Sessao sessaoExistente = new Sessao(as11, deVoltaParaOFuturo, sala1);
		
		List<Sessao> existentes = new ArrayList<>();
		existentes.add(sessaoExistente);

		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(existentes);
		
		LocalTime as11EMeia = LocalTime.of(11, 30);

		Duration media = Duration.ofMinutes(120);
		Filme terminator = new Filme("The Terminator", media, "Ação");

		Sessao nova = new Sessao(as11EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertFalse("Não deveria caber ...", cabe);

	}

	
	@Test
	public void devePermitirNovaSessaoIniciandoAposFimDaJaExistente() {
		LocalTime as11 = LocalTime.of(11, 0);
		
		Duration baixa = Duration.ofMinutes(116);
		Filme deVoltaParaOFuturo = new Filme("Back To The Future", baixa, "Aventura");
		
		Sala sala1 = new Sala("Sala 1");

		Sessao sessaoExistente = new Sessao(as11, deVoltaParaOFuturo, sala1);
		
		List<Sessao> existentes = new ArrayList<>();
		existentes.add(sessaoExistente);

		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(existentes);
		
		LocalTime as13 = LocalTime.of(13, 00);

		Duration media = Duration.ofMinutes(120);
		Filme terminator = new Filme("The Terminator", media, "Ação");

		Sessao nova = new Sessao(as13, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertTrue("Deveria caber ...", cabe);
	}
	

	@Test
	public void devePermitirNovaSessaoTerminandoAntesDoInicioDaJaExistente() {
		LocalTime as11 = LocalTime.of(11, 0);

		Duration baixa = Duration.ofMinutes(116);
		Filme deVoltaParaOFuturo = new Filme("Back To The Future", baixa, "Aventura");
		
		Sala sala1 = new Sala("Sala 1");

		Sessao sessaoExistente = new Sessao(as11, deVoltaParaOFuturo, sala1);
		
		List<Sessao> existentes = new ArrayList<>();
		existentes.add(sessaoExistente);

		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(existentes);
		
		LocalTime as8EMeia = LocalTime.of(8, 30);

		Duration media = Duration.ofMinutes(120);
		Filme terminator = new Filme("The Terminator", media, "Ação");

		Sessao nova = new Sessao(as8EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertTrue("Deveria caber ...", cabe);
	}
	
	
	@Test
	public void naoDevePermitirSessaoFinalizandoNoMeioDaJaExistente() {
		LocalTime as11 = LocalTime.of(11, 0);

		Duration baixa = Duration.ofMinutes(116);
		Filme deVoltaParaOFuturo = new Filme("Back To The Future", baixa, "Aventura");
		
		Sala sala1 = new Sala("Sala 1");

		Sessao sessaoExistente = new Sessao(as11, deVoltaParaOFuturo, sala1);
		
		List<Sessao> existentes = new ArrayList<>();
		existentes.add(sessaoExistente);

		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(existentes);
		
		LocalTime as9EMeia = LocalTime.of(9, 30);

		Duration media = Duration.ofMinutes(120);
		Filme terminator = new Filme("The Terminator", media, "Ação");

		Sessao nova = new Sessao(as9EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertFalse("Não deveria caber ...", cabe);
	}
}






