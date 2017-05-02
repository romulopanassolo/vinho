package com.ubots.dto;

import com.ubots.prova.model.Cliente;

public class ClientesTotalComprasDto {

	private Cliente cliente;
	
	private Double totalCompras;
	
	public ClientesTotalComprasDto(){};
	
	public ClientesTotalComprasDto(Cliente cliente, Double totalCompras) {
		super();
		this.cliente = cliente;
		this.totalCompras = totalCompras;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotalCompras() {
		return totalCompras;
	}

	public void setTotalCompras(Double totalCompras) {
		this.totalCompras = totalCompras;
	}
	
	
	
	
}
