package com.ubots.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.dto.ClientesFielDto;
import com.ubots.prova.business.ClienteBusiness;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.repository.ManageRepositoryDbImpl;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	@Autowired
	private ManageRepositoryDbImpl repository;

	@Autowired
	private ClienteBusiness clienteBusiness;

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public List<Cliente> cadastra(@RequestBody List<Cliente> clientes) {
		return this.repository.cadastraClientes(clientes);
	}

	@RequestMapping(value = "/fieis", method = RequestMethod.GET)
	public List<ClientesFielDto> listaClintesFieis() {

		List<Compra> compras = repository.buscaCompras();
		List<Cliente> clientes = repository.buscaClientes();

		return this.clienteBusiness.listaClientesFieis(compras, clientes);
	}

}
