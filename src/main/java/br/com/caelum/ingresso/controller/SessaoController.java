package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;

@Controller
public class SessaoController {
	
	@Autowired
	private SalaDao salaDao;

	@Autowired
	private FilmeDao filmeDao;

	@RequestMapping("/admin/sessao")
	public String form(@RequestParam("salaId") Integer salaId, Model model) {
		model.addAttribute("sala", salaDao.findOne(salaId));
		model.addAttribute("filmes", filmeDao.findAll());
		return "sessao/sessao";
	}
}














