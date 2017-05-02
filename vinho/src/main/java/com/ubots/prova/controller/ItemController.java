package com.ubots.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.dto.ItemSugeridoDto;
import com.ubots.prova.business.ItemBusiness;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.model.Item;
import com.ubots.prova.repository.ManageRepositoryDbImpl;

@RestController
@RequestMapping("api/item")
public class ItemController {

	@Autowired
	private ManageRepositoryDbImpl repository;

	@Autowired
	private ItemBusiness itemBusiness;

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public List<Item> cadastra(@RequestBody List<Item> itens) {
		return this.repository.cadastraItens(itens);
	}

	// Recomende um vinho para um determinado cliente a partir do histórico de
	// compras.

	@RequestMapping(value = "/recomendaVinho/{cp}/{f}", method = RequestMethod.GET)
	public ItemSugeridoDto recomentaVinho(@PathVariable("cp") String cp, @PathVariable("f") String f) {

		List<Compra> compras = repository.buscaCompras();
		Cliente cliente = repository.buscaClientePorCPF(cp.concat(f));
		List<Item> itens = repository.buscaItens();

		return this.itemBusiness.recomendaVinhoCliente(compras, cliente, itens);
	}

}
