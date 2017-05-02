package com.ubots.prova.repository;

import java.util.List;

import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.model.Item;

public interface ManageRepository {
	
	
	public List<Compra> gravarCompras(List<Compra> compras);
	
	public List<Cliente> cadastraClientes(List<Cliente> clientes);
	
	public List<Compra> buscaCompras();
	
	public List<Cliente> buscaClientes();
	
	public List<Item> buscaItens();
	
	public Cliente buscaClientePorCPF(String cpf);

}
