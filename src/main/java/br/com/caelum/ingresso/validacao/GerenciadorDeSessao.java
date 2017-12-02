package br.com.caelum.ingresso.validacao;

import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> existentes;
	
	public GerenciadorDeSessao(List<Sessao> existentes) {
		this.existentes = existentes;
	}

	public boolean cabe(Sessao nova) {
		
		for (Sessao existente : existentes) {
			
			LocalTime inicioExistente = existente.getHorario();
			LocalTime inicioNova = nova.getHorario();
	
			LocalTime fimExistente = existente.getHorarioTermino();
			LocalTime fimNova = nova.getHorarioTermino();
			
			if( inicioExistente.equals(inicioNova)
				||
				( inicioExistente.isBefore(inicioNova) 
						&& fimExistente.isAfter(inicioNova) )
						||
			    ( inicioExistente.isAfter(inicioNova) 
								&& inicioExistente.isBefore(fimNova) )
			) {
				return false;
			}
		}
		
		return true;
	}

}
















