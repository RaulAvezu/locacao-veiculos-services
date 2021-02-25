package com.shx.locacao.veiculos.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shx.locacao.veiculos.model.Veiculo;
import com.shx.locacao.veiculos.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarVeiculo() {
		ModelAndView mv = new ModelAndView("listarVeiculo");
		List<Veiculo> obj = service.findAll();
		mv.addObject("listarVeiculo", obj);
		return mv;

	}

	@RequestMapping(value = "/novoVeiculo", method = RequestMethod.GET)
	public ModelAndView novoVeiculo() {
		ModelAndView mv = new ModelAndView("cadastrarVeiculo");
		mv.addObject("cadastrarVeiculo");
		return mv;

	}

	@RequestMapping(value = "/novoVeiculo", method = RequestMethod.POST)
	public ModelAndView saveVeiculo(@Valid Veiculo obj) {
		ModelAndView mv = new ModelAndView("redirect:/veiculos");
		obj = service.insert(obj);
		List<Veiculo> obj1 = service.findAll();
		mv.addObject("listarVeiculo", obj1);
		return mv;
	}

	@RequestMapping(value = "/editarVeiculo/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid Veiculo obj) {
		ModelAndView mv = new ModelAndView("redirect:/veiculos");
		obj = service.update(obj);
		return mv;
	}

	@RequestMapping(value = "/editarVeiculo/{id}", method = RequestMethod.GET)
	public ModelAndView editarVeiculo(@PathVariable Integer id) {
		Veiculo obj = service.find(id);
		ModelAndView mv = new ModelAndView("editarVeiculo");
		mv.addObject("editarVeiculo", obj);
		return mv;

	}

	@RequestMapping(value = "/deletar/{id}")
	public ModelAndView deletarVeiculo(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/veiculos");
		service.delete(id);
		return mv;
	}
}
