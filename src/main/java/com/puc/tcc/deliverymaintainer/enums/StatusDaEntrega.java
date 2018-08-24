package com.puc.tcc.deliverymaintainer.enums;

public enum StatusDaEntrega {

	EM_SEPARACAO("EM_SEPARACAO"), 
	ENVIADO("ENVIADO"), 
	EM_TRANSPORTE("EM_TRANSPORTE"), 
	ENTREGUE("ENTREGUE"), 
	PROBLEMAS_NA_ENTREGA("PROBLEMAS_NA_ENTREGA"), 
	CANCELADO("CANCELADO");

	private String descricao;

	private StatusDaEntrega() {
	}
	
	private StatusDaEntrega(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return this.descricao;
	}
}
