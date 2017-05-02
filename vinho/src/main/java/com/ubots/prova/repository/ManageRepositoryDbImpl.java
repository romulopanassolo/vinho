package com.ubots.prova.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.model.Item;

@ManagedBean
public class ManageRepositoryDbImpl implements ManageRepository {
	
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	private List<Compra> compras = new ArrayList<Compra>();
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	private List<Item> itens = new ArrayList<Item>();

	

	public List<Compra> gravarCompras(List<Compra> compras) {
		compras.forEach(c -> gravaCompra(c));
		
		return buscaCompras();
	}

	private void gravaCompra(Compra c) {
		List<Item> itens = new ArrayList<Item>();
		itens.addAll(c.getItens());
		c.setItens(null);

		String oldS = c.getCliente().substring(11, 14);
		String newS = "-".concat(c.getCliente().substring(12, 14));

		Cliente clienteCompra = buscaClientePorCPF(c.getCliente().replace(oldS, newS));
		c.setClienteCompra(clienteCompra);
		Compra compra = this.compraRepository.save(c);

		itens.forEach(i -> i.setCompra(compra));
		this.itemRepository.save(itens);
	}

	
	public List<Cliente> cadastraClientes(List<Cliente> clientes) {
		return clienteRepository.save(clientes);
	}
	
	public List<Item> cadastraItens(List<Item> itens) {
		return itemRepository.save(itens);
	}
	
	
	public List<Compra> buscaCompras() {
		if (getCompras().isEmpty()) {
			setCompras(compraRepository.findAll());
		}

		return getCompras();
	}

	
	public List<Cliente> buscaClientes() {
		if (getClientes().isEmpty()) {
			setClientes(clienteRepository.findAll());
		}
		return getClientes();
	}
	
	
	public List<Item> buscaItens() {
		if (getItens().isEmpty()) {
			setItens(itemRepository.findAll());
		}
		return getItens();
	}
	
	
	public Cliente buscaClientePorCPF(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
	
	
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
}
