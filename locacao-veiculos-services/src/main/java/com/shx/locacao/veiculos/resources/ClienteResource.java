package com.shx.locacao.veiculos.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shx.locacao.veiculos.model.Cliente;
import com.shx.locacao.veiculos.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarClientes() {
		ModelAndView mv = new ModelAndView("listarCliente");
		List<Cliente> obj = service.findAll();
		mv.addObject("listarCliente", obj);
		return mv;

	}

	@RequestMapping(value = "/novoCliente", method = RequestMethod.GET)
	public ModelAndView novoCliente() {
		ModelAndView mv = new ModelAndView("cadastrarCliente");
		mv.addObject("cadastrarCliente");
		return mv;

	}

	@RequestMapping(value = "/novoCliente", method = RequestMethod.POST)
	public ModelAndView saveCliente(@Valid Cliente obj) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		obj = service.insert(obj);
		List<Cliente> obj1 = service.findAll();
		mv.addObject("listarCliente", obj1);
		return mv;
	}

	@RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid Cliente obj) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		obj = service.update(obj);
		return mv;
	}

	@RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.GET)
	public ModelAndView editarCliente(@PathVariable Integer id) {
		Cliente obj = service.find(id);
		ModelAndView mv = new ModelAndView("editarCliente");
		mv.addObject("editarCliente", obj);
		return mv;

	}

	@RequestMapping(value = "/deletar/{id}")
	public ModelAndView deletarCliente(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		service.delete(id);
		return mv;
	}
}
