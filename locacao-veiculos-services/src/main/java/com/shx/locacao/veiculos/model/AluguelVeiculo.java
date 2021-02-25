package com.shx.locacao.veiculos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AluguelVeiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataLocacao;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;
	private LocalDate dataDevolucao;
	private BigDecimal valorPago;

	public AluguelVeiculo() {

	}
	
	

	public AluguelVeiculo(Integer id, LocalDate dataLocacao, Cliente cliente, Veiculo veiculo, LocalDate dataDevolucao,
			BigDecimal valorPago) {
		super();
		this.id = id;
		this.dataLocacao = dataLocacao;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataDevolucao = dataDevolucao;
		this.valorPago = valorPago;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
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
		AluguelVeiculo other = (AluguelVeiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void calculaValorPago() {
		this.dataDevolucao = LocalDate.now();
		double valorDiaria = this.veiculo.getValorDiaria();
		Period period = Period.between(dataLocacao, this.dataDevolucao);
		int dias = period.getDays();
		//valorPago = dias * valorDiaria;
		valorPago = BigDecimal.valueOf(valorDiaria*dias);
	}

}
