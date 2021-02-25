package com.shx.locacao.veiculos.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AluguelVeiculoDTO {

	private Integer id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataLocacao;

	private Integer cliente;

	private Integer veiculo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDevolucao;
	private BigDecimal valorPago;

	public AluguelVeiculoDTO() {

	}

	public AluguelVeiculoDTO(Integer id, LocalDate dataLocacao, Integer cliente, Integer veiculo,
			LocalDate dataDevolucao, BigDecimal valorPago) {
		super();
		this.id = id;
		this.dataLocacao = dataLocacao;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataDevolucao = dataDevolucao;
		this.valorPago = valorPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AluguelVeiculoDTO other = (AluguelVeiculoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Integer veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

}
