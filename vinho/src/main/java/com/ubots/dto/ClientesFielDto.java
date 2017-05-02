package com.ubots.dto;

import com.ubots.prova.model.Cliente;

public class ClientesFielDto {

	private Cliente cliente;
	
	private Integer numeroCompras;
	
	

	public ClientesFielDto(Cliente cliente, Integer numeroCompras) {
		super();
		this.cliente = cliente;
		this.numeroCompras = numeroCompras;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(Integer numeroCompras) {
		this.numeroCompras = numeroCompras;
	}
	
}
