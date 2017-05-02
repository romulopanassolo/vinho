package com.ubots.prova.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.ubots.dto.ClientesFielDto;
import com.ubots.dto.ClientesTotalComprasDto;
import com.ubots.dto.ItemSugeridoDto;
import com.ubots.prova.model.Cliente;
import com.ubots.prova.model.Compra;
import com.ubots.prova.model.Item;

public class BusinessTest {

	private ClienteBusiness clienteBusiness;

	private CompraBusiness compraBusiness;
	
	private ItemBusiness itemBusiness;
	
	private List<Compra> compras;

	private List<Cliente> clientes;

	private Cliente cliente;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente4;
	private Cliente cliente5;
	
	private Calendar calendarioData2016 = new Calendar.Builder().setDate(2016, 10, 2).setLocale(new Locale("pt", "br"))
			.build();

	private Calendar calendarioData2017 = new Calendar.Builder().setDate(2017, 2, 2).setLocale(new Locale("pt", "br"))
			.build();
	
	
	private List<Item> itens;
	
	@Before
	public void init() {

		cliente = new Cliente();
		cliente.setNome("Um");
		cliente.setCpf("111.111.111-11");
		cliente.setId(Long.valueOf(1));
		
		Compra compraUm = new Compra();
		compraUm.setClienteCompra(cliente);
		compraUm.setValorTotal(Double.valueOf(100));
		compraUm.setDataCompra(calendarioData2016.getTime());
		Compra compraDois = new Compra();
		compraDois.setClienteCompra(cliente);
		compraDois.setValorTotal(Double.valueOf(150));
		compraDois.setDataCompra(calendarioData2016.getTime());
		compras = new ArrayList<Compra>();
		
		clienteBusiness = new ClienteBusiness();
		compraBusiness = new CompraBusiness();
		itemBusiness = new ItemBusiness();
		
		cliente2 = new Cliente();
		cliente2.setNome("Dois");
		cliente2.setCpf("222.222.222-22");
		cliente2.setId(Long.valueOf(2));
		
		Compra compraTres = new Compra();
		compraTres.setClienteCompra(cliente2);
		compraTres.setValorTotal(Double.valueOf(100));
		compraTres.setDataCompra(calendarioData2016.getTime());
		Compra compraQuatro = new Compra();
		compraQuatro.setClienteCompra(cliente2);
		compraQuatro.setValorTotal(Double.valueOf(50));
		compraQuatro.setDataCompra(calendarioData2016.getTime());
		Compra compraCinco = new Compra();
		compraCinco.setClienteCompra(cliente2);
		compraCinco.setValorTotal(Double.valueOf(200));
		compraCinco.setDataCompra(calendarioData2017.getTime());

		cliente3 = new Cliente();
		cliente3.setNome("Tres");
		cliente3.setCpf("333.333.333-33");
		cliente3.setId(Long.valueOf(3));
		
		Compra compraSeis = new Compra();
		compraSeis.setClienteCompra(cliente3);
		compraSeis.setValorTotal(Double.valueOf(100));
		compraSeis.setDataCompra(calendarioData2016.getTime());
		Compra compraSete = new Compra();
		compraSete.setClienteCompra(cliente3);
		compraSete.setValorTotal(Double.valueOf(150));
		compraSete.setDataCompra(calendarioData2016.getTime());
		Compra compraOito = new Compra();
		compraOito.setClienteCompra(cliente3);
		compraOito.setValorTotal(Double.valueOf(50));
		compraOito.setDataCompra(calendarioData2016.getTime());
		Compra compraNove = new Compra();
		compraNove.setClienteCompra(cliente3);
		compraNove.setValorTotal(Double.valueOf(100));
		compraNove.setDataCompra(calendarioData2017.getTime());
		
		
		
		cliente4 = new Cliente();
		cliente4.setNome("Quatro");
		cliente4.setCpf("444.444.444-44");
		cliente4.setId(Long.valueOf(4));
		
		
		Compra compraDez = new Compra();
		compraDez.setClienteCompra(cliente4);
		compraDez.setValorTotal(Double.valueOf(100));
		compraDez.setDataCompra(calendarioData2016.getTime());
		Compra compraOnze = new Compra();
		compraOnze.setClienteCompra(cliente4);
		compraOnze.setValorTotal(Double.valueOf(200));
		compraOnze.setDataCompra(calendarioData2016.getTime());
		Compra compraDoze = new Compra();
		compraDoze.setClienteCompra(cliente4);
		compraDoze.setValorTotal(Double.valueOf(50));
		compraDoze.setDataCompra(calendarioData2016.getTime());
		Compra compraTreze = new Compra();
		compraTreze.setClienteCompra(cliente4);
		compraTreze.setValorTotal(Double.valueOf(150));
		compraTreze.setDataCompra(calendarioData2017.getTime());
		
		cliente5 = new Cliente();
		cliente5.setNome("Quatro");
		cliente5.setCpf("555.555.555-55");
		cliente5.setId(Long.valueOf(5));
		
		Compra compraVinte = new Compra();
		compraVinte.setClienteCompra(cliente5);
		compraVinte.setValorTotal(Double.valueOf(100));
		compraVinte.setDataCompra(calendarioData2016.getTime());
		
		
		compras.add(compraUm);
		compras.add(compraDois);
		compras.add(compraTres);
		compras.add(compraQuatro);
		compras.add(compraCinco);
		compras.add(compraSeis);
		compras.add(compraSete);
		compras.add(compraOito);
		compras.add(compraNove);
		compras.add(compraDez);
		compras.add(compraOnze);
		compras.add(compraDoze);
		compras.add(compraTreze);
		compras.add(compraVinte);
		
		clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		
		
		itens = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setCategoria("Tinto");
		item1.setCompra(compraUm);
		item1.setId(Long.valueOf(1));
		item1.setPreco(Double.valueOf(100));
		item1.setPais("Chile");
		item1.setVariedade("Carbenet Sauvignon");
		item1.setProduto("Ventiskeiro");
		itens.add(item1);
		
		Item item2 = new Item();
		item2.setCategoria("Tinto");
		item2.setCompra(compraDois);
		item2.setId(Long.valueOf(1));
		item2.setPreco(Double.valueOf(100));
		item2.setPais("Chile");
		item2.setVariedade("Shiraz");
		item2.setProduto("Emiliana Novas");
		itens.add(item2);
		
		Item item3 = new Item();
		item3.setCategoria("Tinto");
		item3.setCompra(compraTres);
		item3.setId(Long.valueOf(1));
		item3.setPreco(Double.valueOf(100));
		item3.setPais("Brasil");
		item3.setVariedade("Merlot");
		item3.setProduto("Casa Valduga");
		itens.add(item3);
		
		
		Item item4 = new Item();
		item4.setCategoria("Tinto");
		item4.setCompra(compraQuatro);
		item4.setId(Long.valueOf(1));
		item4.setPreco(Double.valueOf(100));
		item4.setPais("Espanha");
		item4.setVariedade("Tempranillo");
		item4.setProduto("Gato Negro");
		itens.add(item4);
		
		Item item5 = new Item();
		item5.setCategoria("Tinto");
		item5.setCompra(compraCinco);
		item5.setId(Long.valueOf(1));
		item5.setPreco(Double.valueOf(100));
		item5.setPais("Eua");
		item5.setVariedade("Zinfadel");
		item5.setProduto("Waterloo");
		itens.add(item5);
		
		Item item6 = new Item();
		item6.setCategoria("Tinto");
		item6.setCompra(compraSeis);
		item6.setId(Long.valueOf(1));
		item6.setPreco(Double.valueOf(100));
		item6.setPais("Chile");
		item6.setVariedade("Shiraz");
		item6.setProduto("Cassilero del diablo");
		itens.add(item6);
		
		Item item7 = new Item();
		item7.setCategoria("Tinto");
		item7.setCompra(compraSete);
		item7.setId(Long.valueOf(1));
		item7.setPreco(Double.valueOf(100));
		item7.setPais("Brasil");
		item7.setVariedade("Merlot");
		item7.setProduto("Casa Valduga");
		itens.add(item7);
		
		Item item8 = new Item();
		item8.setCategoria("Tinto");
		item8.setCompra(compraOito);
		item8.setId(Long.valueOf(1));
		item8.setPreco(Double.valueOf(100));
		item8.setPais("Chile");
		item8.setVariedade("Carbenet Sauvignon");
		item8.setProduto("Casilero del Diablo");
		itens.add(item8);
		
		Item item9 = new Item();
		item9.setCategoria("Tinto");
		item9.setCompra(compraNove);
		item9.setId(Long.valueOf(1));
		item9.setPreco(Double.valueOf(100));
		item9.setPais("Espanha");
		item9.setVariedade("Tempranillo");
		item9.setProduto("Emiliana Novas");
		itens.add(item9);
		
		
		Item item10 = new Item();
		item10.setCategoria("Tinto");
		item10.setCompra(compraDez);
		item10.setId(Long.valueOf(1));
		item10.setPreco(Double.valueOf(100));
		item10.setPais("Chile");
		item10.setVariedade("Shiraz");
		item10.setProduto("Casileiro del diablo");
		itens.add(item10);
		
		List<Item> listItemCompra10 = new ArrayList<Item>();
		listItemCompra10.add(item10);
		compraDez.setItens(listItemCompra10);
		
		Item item11 = new Item();
		item11.setCategoria("Tinto");
		item11.setCompra(compraOnze);
		item11.setId(Long.valueOf(1));
		item11.setPreco(Double.valueOf(100));
		item11.setPais("Chile");
		item11.setVariedade("Shiraz");
		item11.setProduto("Carmen");
		itens.add(item11);
		
		
		List<Item> listItemCompra11 = new ArrayList<Item>();
		listItemCompra11.add(item11);
		compraOnze.setItens(listItemCompra11);
		
		Item item12 = new Item();
		item12.setCategoria("Tinto");
		item12.setCompra(compraDoze);
		item12.setId(Long.valueOf(1));
		item12.setPreco(Double.valueOf(100));
		item12.setPais("Chile");
		item12.setVariedade("Shiraz");
		item12.setProduto("Trio Casileiro");
		itens.add(item12);
		
		
		List<Item> listItemCompra12 = new ArrayList<Item>();
		listItemCompra12.add(item12);
		compraDoze.setItens(listItemCompra12);
		
		Item item13 = new Item();
		item13.setCategoria("Tinto");
		item13.setCompra(compraTreze);
		item13.setId(Long.valueOf(1));
		item13.setPreco(Double.valueOf(100));
		item13.setPais("Chile");
		item13.setVariedade("Carbenet Sauvignon");
		item13.setProduto("Ventiskeiro");
		itens.add(item13);

		List<Item> listItemCompra13 = new ArrayList<Item>();
		listItemCompra13.add(item13);
		compraTreze.setItens(listItemCompra13);
		
		Item item20 = new Item();
		item20.setCategoria("Tinto");
		item20.setCompra(compraDois);
		item20.setId(Long.valueOf(1));
		item20.setPreco(Double.valueOf(100));
		item20.setPais("Africa do Sul");
		item20.setVariedade("Shiraz");
		item20.setProduto("Obikwa");
		itens.add(item20);
		
		
		
	}

	
	@Test
	public void findTotalTest(){
		Double expected = Double.valueOf(500);
		Double actual = compraBusiness.findTotal(compras, cliente4);
		assertEquals(expected, actual);
	}
	
	@Test
	public void listaClientesByTotalCompras(){
		
		List<ClientesTotalComprasDto> expectedListaClientes = new ArrayList<ClientesTotalComprasDto>();
		
		expectedListaClientes.add(new ClientesTotalComprasDto(cliente4, Double.valueOf(500)));
		expectedListaClientes.add(new ClientesTotalComprasDto(cliente3, Double.valueOf(400)));
		expectedListaClientes.add(new ClientesTotalComprasDto(cliente2, Double.valueOf(350)));
		expectedListaClientes.add(new ClientesTotalComprasDto(cliente, Double.valueOf(250)));
		expectedListaClientes.add(new ClientesTotalComprasDto(cliente5, Double.valueOf(100)));
		
		List<ClientesTotalComprasDto> actualListaClientes = compraBusiness.listaClientesByTotalCompras(compras, clientes);
		
		assertEquals(expectedListaClientes.get(0).getCliente().getId(), actualListaClientes.get(0).getCliente().getId());
		assertEquals(expectedListaClientes.get(1).getCliente().getId(), actualListaClientes.get(1).getCliente().getId());
		assertEquals(expectedListaClientes.get(2).getCliente().getId(), actualListaClientes.get(2).getCliente().getId());
		assertEquals(expectedListaClientes.get(3).getCliente().getId(), actualListaClientes.get(3).getCliente().getId());
		assertEquals(expectedListaClientes.get(4).getCliente().getId(), actualListaClientes.get(4).getCliente().getId());
		
	}
	
	
	@Test
	public void buscaClienteMaiorCompra(){
		Cliente clienteMaiorCompraActual = compraBusiness.buscaClinteMaiorCompra(compras);
		assertEquals(cliente4, clienteMaiorCompraActual);
	}
	
	
	
	@Test
	public void findNumeroComprasTest() {
		Integer expected = Integer.valueOf("2");
		Integer actual = clienteBusiness.findNumeroCompras(compras, cliente);
		assertEquals(expected, actual);
	}

	@Test
	public void listaClientesFieisTest() {
		
		List<ClientesFielDto> clienteFieis = new ArrayList<ClientesFielDto>();
		clienteFieis.add(new ClientesFielDto(cliente5, 1));
		clienteFieis.add(new ClientesFielDto(cliente, 2));
		clienteFieis.add(new ClientesFielDto(cliente2, 3));
		clienteFieis.add(new ClientesFielDto(cliente3, 4));
		clienteFieis.add(new ClientesFielDto(cliente4, 4));
		List<ClientesFielDto> clienteFieisAtual = clienteBusiness.listaClientesFieis(compras, clientes);
		
		assertEquals(clienteFieis.get(0).getCliente().getId(), clienteFieisAtual.get(0).getCliente().getId());
		assertEquals(clienteFieis.get(1).getCliente().getId(), clienteFieisAtual.get(1).getCliente().getId());
		assertEquals(clienteFieis.get(2).getCliente().getId(), clienteFieisAtual.get(2).getCliente().getId());
		assertEquals(clienteFieis.get(3).getCliente().getId(), clienteFieisAtual.get(3).getCliente().getId());
		assertEquals(clienteFieis.get(4).getCliente().getId(), clienteFieisAtual.get(4).getCliente().getId());
		
	}

	@Test
	public void recomendaVinhoClienteTest(){
		
		Item itemSugerido = new Item();
		itemSugerido.setCategoria("Tinto");
		itemSugerido.setId(Long.valueOf(1));
		itemSugerido.setPreco(Double.valueOf(100));
		itemSugerido.setPais("Chile");
		itemSugerido.setVariedade("Shiraz");
		itemSugerido.setProduto("Emiliana Novas");
		itens.add(itemSugerido);
		
		ItemSugeridoDto vinhoSugeridoExpected = new ItemSugeridoDto(itemSugerido);
		
		ItemSugeridoDto vinho = itemBusiness.recomendaVinhoCliente(compras, cliente4, itens);
		
		assertEquals(vinhoSugeridoExpected.getCategoria(), vinho.getCategoria());
		assertEquals(vinhoSugeridoExpected.getProduto(), vinho.getProduto());
		assertEquals(vinhoSugeridoExpected.getVariedade(), vinho.getVariedade());
		assertEquals(vinhoSugeridoExpected.getPais(), vinho.getPais());
		
	}
	
}
