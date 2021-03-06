package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {

	@Id @GeneratedValue
	private Integer id;
	
	private LocalTime horario;

	private BigDecimal preco;
	
	@ManyToOne
	private Filme filme;
	
	@ManyToOne
	private Sala sala;

	/**
	 * @deprecated hibernate only
	 */
	public Sessao() {
	}
	
	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public LocalTime getHorario() {
		return horario;
	}
	
	public LocalTime getHorarioTermino() {
		return horario.plusMinutes(filme.getDuracao().toMinutes());
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
