package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;

@Controller
public class SessaoController {
	
	@Autowired
	private SalaDao salaDao;

	@Autowired
	private FilmeDao filmeDao;

	@GetMapping("/admin/sessao")
	public ModelAndView form(@RequestParam("salaId") Integer salaId) {
		ModelAndView mav = new ModelAndView("sessao/sessao");
		mav.addObject("sala", salaDao.findOne(salaId));
		mav.addObject("filmes", filmeDao.findAll());
		return mav;
	}
	
	@PostMapping("/admin/sessao")
	@Transactional
	public ModelAndView salva() {
		//TODO: usar id da sala no redirect
		ModelAndView mav = new ModelAndView("redirect:/admin/sala/1/sessoes/");
		//TODO: salvar a sessao aqui...
		return mav;
	}
}














