package com.ubots.prova.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;

import com.ubots.dto.ClientesTotalComprasDto;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;

@ManagedBean
public class CompraBusiness {

	
	public List<ClientesTotalComprasDto> listaClientesByTotalCompras(List<Compra> compras, List<Cliente> clientes) {
		
		List<ClientesTotalComprasDto> clientesTotalComprasDto = new ArrayList<ClientesTotalComprasDto>();

		clientes.forEach(c -> clientesTotalComprasDto.add(new ClientesTotalComprasDto(c, findTotal(compras, c))));
		clientesTotalComprasDto.sort((pw1, pw2) -> Double.compare(pw2.getTotalCompras(), pw1.getTotalCompras()));

		return clientesTotalComprasDto;
	}

	protected Double findTotal(List<Compra> compras, Cliente cliente) {
		Double sum = compras.stream().filter(c -> c.getClienteCompra().equals(cliente))
				.mapToDouble(i -> i.getValorTotal()).sum();
		return sum;
	}

	public Cliente buscaClinteMaiorCompra(List<Compra> compras) {
		
		Calendar calendarioInicio = new Calendar.Builder().setDate(2016, 0, 1).setLocale(new Locale("pt", "br"))
				.build();

		Calendar calendarioFim = new Calendar.Builder().setDate(2016, 13, 31).setLocale(new Locale("pt", "br")).build();

		calendarioInicio.getTime();

		List<Compra> comprasFiltrada = compras.stream().filter(c -> c.getDataCompra().before(calendarioFim.getTime())
				&& c.getDataCompra().after(calendarioInicio.getTime())).collect(Collectors.toList());

		comprasFiltrada.sort((c1, c2) -> Double.compare(c1.getValorTotal(), c2.getValorTotal()));

		return comprasFiltrada.get(comprasFiltrada.size() - 1).getClienteCompra();
	}


}
