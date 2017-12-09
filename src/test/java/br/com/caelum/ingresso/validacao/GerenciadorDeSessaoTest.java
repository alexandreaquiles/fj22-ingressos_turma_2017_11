package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {

	private List<Sessao> existentes;
	private GerenciadorDeSessao gerenciador;
	private Sala sala1;
	private Filme terminator;
	private Filme deVoltaParaOFuturo;

	@Before
	public void criaGerenciador() {
		//ARRANGE - criar os objetos
		LocalTime as11 = LocalTime.of(11, 0);
		
		Duration baixa = Duration.ofMinutes(116);
		deVoltaParaOFuturo = new Filme("Back To The Future", baixa, "Aventura");
		
		sala1 = new Sala("Sala 1");

		Sessao sessaoExistente = new Sessao(as11, deVoltaParaOFuturo, sala1);
		
		existentes = new ArrayList<>();
		existentes.add(sessaoExistente);

		gerenciador = new GerenciadorDeSessao(existentes);

		Duration media = Duration.ofMinutes(120);
		terminator = new Filme("The Terminator", media, "Ação");
	}
	
	@Test
	public void naoDevePermitirSessaoIniciandoNoMesmoHorarioDeUmaJaExistente () {
		LocalTime as11DeNovo = LocalTime.of(11, 0);

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
		LocalTime as11EMeia = LocalTime.of(11, 30);

		Sessao nova = new Sessao(as11EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertFalse("Não deveria caber ...", cabe);

	}

	
	@Test
	public void devePermitirNovaSessaoIniciandoAposFimDaJaExistente() {
		LocalTime as13 = LocalTime.of(13, 00);

		Sessao nova = new Sessao(as13, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertTrue("Deveria caber ...", cabe);
	}
	

	@Test
	public void devePermitirNovaSessaoTerminandoAntesDoInicioDaJaExistente() {
		LocalTime as8EMeia = LocalTime.of(8, 30);

		Sessao nova = new Sessao(as8EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertTrue("Deveria caber ...", cabe);
	}
	
	
	@Test
	public void naoDevePermitirSessaoFinalizandoNoMeioDaJaExistente() {
		LocalTime as9EMeia = LocalTime.of(9, 30);

		Sessao nova = new Sessao(as9EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertFalse("Não deveria caber ...", cabe);
	}
	
	@Test
	public void devePermitirUmaSessaoEntreDuasJaExistentesQuandoCouber() {
		LocalTime as18 = LocalTime.of(18, 0);
		Sessao outraSessaoExistente = new Sessao(as18, deVoltaParaOFuturo, sala1);
		existentes.add(outraSessaoExistente);

		LocalTime as13EMeia = LocalTime.of(13, 30);
		Sessao nova = new Sessao(as13EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertTrue("Deveria caber ...", cabe);
	}

	@Test
	public void naoDevePermitirUmaSessaoEntreDuasJaExistentesSeNAOCouber() {
		LocalTime as15 = LocalTime.of(15, 0);
		Sessao outraSessaoExistente = new Sessao(as15, deVoltaParaOFuturo, sala1);
		existentes.add(outraSessaoExistente);
		
		LocalTime as13EMeia = LocalTime.of(13, 30);

		Sessao nova = new Sessao(as13EMeia, terminator, sala1);
		
		boolean cabe = gerenciador.cabe(nova);

		Assert.assertFalse("Não deveria caber ...", cabe);
	}

}






