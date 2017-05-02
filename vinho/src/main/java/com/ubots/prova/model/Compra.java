package com.ubots.prova.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	@Transient
	private String data;

	@Transient
	private String cliente;

    @OneToOne(targetEntity=Cliente.class, fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
	private Cliente clienteCompra;
	
	
	private Date dataCompra;

	@OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "compra_id")
	private List<Item> itens;

	private Double valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		
		
		Integer dia = Integer.valueOf(data.substring(0,2));
		Integer mes = Integer.valueOf(data.substring(3,5));
		Integer ano = Integer.valueOf(data.substring(6,10));
		
		Calendar calendario =  
			      new Calendar.Builder()  
			        .setDate(ano, mes-1, dia)  
			        .setLocale(new Locale("pt", "br"))
			        .build();
		
		
		setDataCompra(calendario.getTime());
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Cliente getClienteCompra() {
		return clienteCompra;
	}

	public void setClienteCompra(Cliente clienteCompra) {
		this.clienteCompra = clienteCompra;
	}

	
	
}
