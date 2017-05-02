package com.ubots.dto;

import com.ubots.prova.model.Item;

public class ItemSugeridoDto {
	
private String produto;
	
	private String variedade;
	
	private String pais;
	
	private String categoria;
	
	private String safra;
	
	private Double preco;

	public ItemSugeridoDto(Item item) {
		super();
		this.produto = item.getProduto();
		this.variedade = item.getVariedade();
		this.pais = item.getPais();
		this.categoria = item.getCategoria();
		this.safra = item.getSafra();
		this.preco = item.getPreco();
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSafra() {
		return safra;
	}

	public void setSafra(String safra) {
		this.safra = safra;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
