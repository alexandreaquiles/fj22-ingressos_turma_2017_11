package br.com.caelum.ingresso.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Service
public class ImdbClient {
	
	public DetalhesDoFilme request(Filme filme) {
		String titulo = filme.getNome().replace(" ", "+");

		RestTemplate restTemplate = new RestTemplate();
		
		String  url = "http://imdb-fj22.herokuapp.com/imdb?title=" + titulo;
		
		DetalhesDoFilme detalhes = restTemplate.getForObject(url, DetalhesDoFilme.class);
		
		return detalhes;
	}
	
	
}
