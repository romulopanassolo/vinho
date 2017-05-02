package com.ubots.prova.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;

import com.ubots.dto.ItemSugeridoDto;
import com.ubots.dto.TotalizadorDto;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.model.Item;

@ManagedBean
public class ItemBusiness {
	
public ItemSugeridoDto recomendaVinhoCliente(List<Compra> compras, Cliente cliente, List<Item> itens) {
		
		List<Item> itensComprados = new ArrayList<Item>();
		List<Compra> comprasByCliente = compras.stream().filter(c -> c.getClienteCompra().equals(cliente))
				.collect(Collectors.toList());
		comprasByCliente.forEach(cbc -> itensComprados.addAll(cbc.getItens()));

		Map<String, Set<String>> resultadoCategoria = itensComprados.stream().collect(
				Collectors.groupingBy(Item::getCategoria, Collectors.mapping(Item::getVariedade, Collectors.toSet())));

		Map<String, Set<Long>> resultadovariedade = itensComprados.stream().collect(
				Collectors.groupingBy(Item::getVariedade, Collectors.mapping(Item::getId, Collectors.toSet())));

		Map<String, Set<String>> resultadoPais = itensComprados.stream().collect(
				Collectors.groupingBy(Item::getPais, Collectors.mapping(Item::getVariedade, Collectors.toSet())));

		List<TotalizadorDto> filterCategoriaDto = new ArrayList<TotalizadorDto>();
		List<TotalizadorDto> filterVariedadeDto = new ArrayList<TotalizadorDto>();
		List<TotalizadorDto> filterPaisDto = new ArrayList<TotalizadorDto>();

		resultadoCategoria.entrySet()
				.forEach(e -> filterCategoriaDto.add(new TotalizadorDto(e.getKey(), e.getValue().size())));
		resultadovariedade.entrySet()
				.forEach(e -> filterVariedadeDto.add(new TotalizadorDto(e.getKey(), e.getValue().size())));
		resultadoPais.entrySet().forEach(e -> filterPaisDto.add(new TotalizadorDto(e.getKey(), e.getValue().size())));

		filterCategoriaDto.sort((t1, t2) -> Integer.compare(t1.getTotal(), t2.getTotal()));
		filterVariedadeDto.sort((t1, t2) -> Integer.compare(t1.getTotal(), t2.getTotal()));
		filterPaisDto.sort((t1, t2) -> Integer.compare(t1.getTotal(), t2.getTotal()));

		List<TotalizadorDto> totalizadores = new ArrayList<TotalizadorDto>();
		totalizadores.add(filterCategoriaDto.get(filterCategoriaDto.size() - 1));
		totalizadores.add(filterVariedadeDto.get(filterVariedadeDto.size() - 1));
		totalizadores.add(filterCategoriaDto.get(filterCategoriaDto.size() - 1));

		TotalizadorDto filterCategoria = filterCategoriaDto.get(filterCategoriaDto.size() - 1);
		TotalizadorDto filterVariedade = filterVariedadeDto.get(filterVariedadeDto.size() - 1);
		TotalizadorDto filterPais = filterPaisDto.get(filterPaisDto.size() - 1);

		totalizadores.sort((t1, t2) -> Integer.compare(t1.getTotal(), t2.getTotal()));

		List<Item> itensSugerido = new ArrayList<>();
		
		itensSugerido = filtraPorTotalizador(totalizadores.get(2).getFilter(), itens, filterCategoria,
				filterVariedade, filterPais);

		List<Item> itensSugerido2 = filtraPorTotalizador(totalizadores.get(1).getFilter(), itensSugerido,
				filterCategoria, filterVariedade, filterPais);

		List<Item> itensSugerido3 = filtraPorTotalizador(totalizadores.get(0).getFilter(), itensSugerido2,
				filterCategoria, filterVariedade, filterPais);

		Item item = itensSugerido.get(0);

		if (itensSugerido2.size() > 0) {

			item = itensSugerido2.get(0);
		}

		if (itensSugerido3.size() > 0) {

			item = itensSugerido3.get(0);
		}

		ItemSugeridoDto itemSugerido = new ItemSugeridoDto(item);

		//
		return itemSugerido;
	}

	private List<Item> filtraPorTotalizador(String filter, List<Item> itemGeral, TotalizadorDto filterCategoria,
			TotalizadorDto filterVariedade, TotalizadorDto filterPais) {

		List<Item> itemFiltrado = new ArrayList<>();

		if (filter.equals(filterCategoria.getFilter())) {
			itemFiltrado.addAll(
					itemGeral.stream().filter(it -> it.getCategoria().equals(filter)).collect(Collectors.toList()));
		}

		if (filter.equals(filterVariedade.getFilter())) {
			itemFiltrado.addAll(
					itemGeral.stream().filter(it -> it.getVariedade().equals(filter)).collect(Collectors.toList()));
		}

		if (filter.equals(filterPais.getFilter())) {
			itemFiltrado
					.addAll(itemGeral.stream().filter(it -> it.getPais().equals(filter)).collect(Collectors.toList()));
		}

		return itemFiltrado;
	}

	
}
