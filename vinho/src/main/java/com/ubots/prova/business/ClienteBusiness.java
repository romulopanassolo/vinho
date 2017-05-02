package com.ubots.prova.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;

import com.ubots.dto.ClientesFielDto;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;

@ManagedBean
public class ClienteBusiness {

	// top 5 clientes fieis
	public List<ClientesFielDto> listaClientesFieis(List<Compra> compras, List<Cliente> clientes) {

		List<ClientesFielDto> clienteFieis = new ArrayList<ClientesFielDto>();
		clientes.forEach(c -> clienteFieis.add(new ClientesFielDto(c, findNumeroCompras(compras, c))));
		clienteFieis.sort((cf1, cf2) -> Integer.compare(cf1.getNumeroCompras(), cf2.getNumeroCompras()));

		return clienteFieis.subList(clienteFieis.size() - 5, clienteFieis.size());
	}

	protected Integer findNumeroCompras(List<Compra> compras, Cliente cliente) {
		List<Compra> comprasByCliente = compras.stream().filter(c -> c.getClienteCompra().equals(cliente))
				.collect(Collectors.toList());
		return comprasByCliente.size();
	}

}
