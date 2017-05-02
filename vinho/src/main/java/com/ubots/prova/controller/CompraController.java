package com.ubots.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.dto.ClientesTotalComprasDto;
import com.ubots.prova.business.CompraBusiness;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.repository.ManageRepositoryDbImpl;

@RestController
@RequestMapping("api/compra")
public class CompraController {

	@Autowired
	private CompraBusiness compraBusiness;

	// private ManageRepository repository = new ManageRepositoryDbImpl();

	@Autowired
	private ManageRepositoryDbImpl repository;

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public List<Compra> cadastra(@RequestBody List<Compra> compra) {
		return this.repository.gravarCompras(compra);
	}

	@RequestMapping(value = "/totalCompras", method = RequestMethod.GET)
	public List<ClientesTotalComprasDto> listaClintesByTotalCompras() {
		
		List<Compra> compras = repository.buscaCompras();
		List<Cliente> clientes = repository.buscaClientes();

		return this.compraBusiness.listaClientesByTotalCompras(compras, clientes);
	}

	// Mostre o cliente com maior compra única no último ano (2016)
	@RequestMapping(value = "/compraUnica", method = RequestMethod.GET)
	public Cliente buscaClinteMaiorCompra() {
		
		List<Compra> compras = repository.buscaCompras();
		
		return this.compraBusiness.buscaClinteMaiorCompra(compras);
	}



}
