package com.shx.locacao.veiculos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shx.locacao.veiculos.enumerations.VeiculoStatusEnum;
import com.shx.locacao.veiculos.model.Veiculo;
import com.shx.locacao.veiculos.repositories.VeiculoRepository;
import com.shx.locacao.veiculos.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repo;

	public Veiculo find(Integer id) {
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
	}

	public Veiculo insert(Veiculo obj) {
		obj.setId(null);
		obj.setStatus(VeiculoStatusEnum.ATIVO);
		return repo.save(obj);
	}

	public Veiculo update(Veiculo obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public List<Veiculo> findAll() {
		return repo.findAll();
	}
	
	public void alteraStatusIndisponivel(Veiculo veiculo) {
		veiculo.setStatus(VeiculoStatusEnum.INATIVO);
		repo.save(veiculo);
	}
	
	public void alteraStatusDisponivel(Veiculo veiculo) {
		veiculo.setStatus(VeiculoStatusEnum.INATIVO);
		repo.save(veiculo);
	}
}
