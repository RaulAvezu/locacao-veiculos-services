package com.shx.locacao.veiculos.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shx.locacao.veiculos.model.AluguelVeiculo;
import com.shx.locacao.veiculos.model.Cliente;
import com.shx.locacao.veiculos.model.Veiculo;
import com.shx.locacao.veiculos.model.dto.AluguelVeiculoDTO;
import com.shx.locacao.veiculos.services.AluguelService;
import com.shx.locacao.veiculos.services.ClienteService;
import com.shx.locacao.veiculos.services.VeiculoService;

@RestController
@RequestMapping(value = "/aluguelVeiculos")
public class AluguelResource {

	@Autowired
	private AluguelService aluguelService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarAluguelVeiculo() {
		ModelAndView mv = new ModelAndView("listarAluguelVeiculo");
		List<AluguelVeiculo> alugueis = aluguelService.findAll();
		mv.addObject("alugueis", alugueis);
		return mv;

	}

	@RequestMapping(value = "/novoAluguelVeiculo", method = RequestMethod.GET)
	public ModelAndView novoAluguelVeiculo() {
		ModelAndView mv = new ModelAndView("cadastrarAluguelVeiculo");
		List<Cliente> clientes = clienteService.findAll();
		List<Veiculo> veiculos = veiculoService.findAll();
		mv.addObject("cadastrarAluguelVeiculo");
		mv.addObject("clientes", clientes);
		mv.addObject("veiculos", veiculos);
		return mv;

	}

	@RequestMapping(value = "/novoAluguelVeiculo", method = RequestMethod.POST)
	public ModelAndView saveAluguelVeiculo(AluguelVeiculoDTO aluguelVeiculoDTO) {
		ModelAndView mv = new ModelAndView("redirect:/aluguelVeiculos");
		aluguelService.insert(aluguelVeiculoDTO);
		List<AluguelVeiculo> obj1 = aluguelService.findAll();
		mv.addObject("listarAluguelVeiculo", obj1);
		return mv;
	}

	@RequestMapping(value = "/editarAluguelVeiculo/{id}", method = RequestMethod.POST)
	public ModelAndView update(@Valid AluguelVeiculo obj) {
		ModelAndView mv = new ModelAndView("redirect:/aluguelVeiculos");
		obj = aluguelService.update(obj);
		return mv;
	}

	@RequestMapping(value = "/editarAluguelVeiculo/{id}", method = RequestMethod.GET)
	public ModelAndView editarAluguelVeiculo(@PathVariable Integer id) {
		AluguelVeiculo obj = aluguelService.find(id);
		ModelAndView mv = new ModelAndView("editarAluguelVeiculo");
		mv.addObject("editarAluguelVeiculo", obj);
		return mv;

	}

	@RequestMapping(value = "/deletar/{id}")
	public ModelAndView deletarAluguelVeiculo(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/aluguelVeiculos");
		aluguelService.delete(id);
		return mv;
	}

	@RequestMapping(value = "/devolucao/{id}", method = RequestMethod.GET)
	public ModelAndView devolucao(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("devolucaoAluguelVeiculo");
		AluguelVeiculo aluguel = aluguelService.find(id);
		aluguel.calculaValorPago();
		mv.addObject("aluguel", aluguel);
		return mv;

	}
	
	@RequestMapping(value = "/devolucao/{id}", method = RequestMethod.POST)
	public ModelAndView devolucaoConfirmar(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/aluguelVeiculos");
		aluguelService.devolver(id);
		return mv;

	}
	
}
