package com.shx.locacao.veiculos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.shx.locacao.veiculos.enumerations.VeiculoStatusEnum;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(max = 30)
	private String marca;
	@Size(max = 100)
	private String nome;
	
	@Min(2000)
	@Max(2100)
	private int ano;
	
	@Min(2000)
	@Max(2100)
	private int modelo;
	
	private String combustivel;
	private double valorDiaria;
	
	@Enumerated(EnumType.STRING)
	private VeiculoStatusEnum status;

	public Veiculo() {

	}

	public Veiculo(Integer id) {
		super();
		this.id = id;
	}

	public Veiculo(Integer id, String marca, String nome, int ano, int modelo, String combustivel,
			double valorDiaria, VeiculoStatusEnum status) {
		super();
		this.id = id;
		this.marca = marca;
		this.nome = nome;
		this.ano = ano;
		this.modelo = modelo;
		this.combustivel = combustivel;
		this.valorDiaria = valorDiaria;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public VeiculoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(VeiculoStatusEnum status) {
		this.status = status;
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
