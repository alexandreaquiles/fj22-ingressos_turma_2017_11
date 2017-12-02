package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {

	private Integer id;
	
	@NotNull(message="Campo obrigatório")
	private Integer salaId;
	
	@NotNull(message="Campo obrigatório")
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime horario;
	
	@NotNull(message="Campo obrigatório")
	private Integer filmeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	public Sessao toSessao() {
		Sessao sessao = new Sessao();
		sessao.setId(this.id);
		
		Filme filme = new Filme(filmeId);
		sessao.setFilme(filme);

		Sala sala = new Sala(salaId);
		sessao.setSala(sala);
		
		sessao.setHorario(this.horario);
		
		return sessao;
	}

}















