package com.ubots.dto;

public class TotalizadorDto {
	
	private String filter;
	
	private Integer total;

	public TotalizadorDto(String filter, Integer total) {
		this.filter = filter;
		this.total = total;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
	
	

}
