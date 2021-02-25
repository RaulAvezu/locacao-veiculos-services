package com.shx.locacao.veiculos.enumerations;

public enum VeiculoStatusEnum {
	ATIVO,
	INATIVO;
	
	public boolean isActive() {
		return this == VeiculoStatusEnum.ATIVO;
	}
	
	public boolean isInactive() {
		return this == VeiculoStatusEnum.INATIVO;
	}
}
