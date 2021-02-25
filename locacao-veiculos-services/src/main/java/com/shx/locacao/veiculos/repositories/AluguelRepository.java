package com.shx.locacao.veiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shx.locacao.veiculos.model.AluguelVeiculo;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelVeiculo, Integer> {

}
