package com.shx.locacao.veiculos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shx.locacao.veiculos.model.AluguelVeiculo;
import com.shx.locacao.veiculos.model.Cliente;
import com.shx.locacao.veiculos.model.Veiculo;
import com.shx.locacao.veiculos.model.dto.AluguelVeiculoDTO;
import com.shx.locacao.veiculos.repositories.AluguelRepository;
import com.shx.locacao.veiculos.services.exceptions.ObjectNotFoundException;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository repo;
	
	@Autowired
	private VeiculoService veiculoService;

	public AluguelVeiculo find(Integer id) {
		Optional<AluguelVeiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + AluguelVeiculo.class.getName()));
	}

	public AluguelVeiculo insert(AluguelVeiculoDTO aluguelVeiculoDTO) {
		Cliente cliente = new Cliente(aluguelVeiculoDTO.getCliente());
		Veiculo veiculo = veiculoService.find(aluguelVeiculoDTO.getVeiculo());
		AluguelVeiculo aluguelVeiculoEntidade = new AluguelVeiculo(null, aluguelVeiculoDTO.getDataLocacao(), cliente,
				veiculo, aluguelVeiculoDTO.getDataDevolucao(), aluguelVeiculoDTO.getValorPago());
		veiculoService.alteraStatusIndisponivel(veiculo);
		return repo.save(aluguelVeiculoEntidade);
		
	}

	public AluguelVeiculo update(AluguelVeiculo obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public List<AluguelVeiculo> findAll() {
		return repo.findAll();
	}
	
	public void devolver(Integer id) {
		AluguelVeiculo aluguelVeiculo = find(id);
		aluguelVeiculo.calculaValorPago();
		veiculoService.alteraStatusDisponivel(aluguelVeiculo.getVeiculo());
		repo.save(aluguelVeiculo);
	}
}
