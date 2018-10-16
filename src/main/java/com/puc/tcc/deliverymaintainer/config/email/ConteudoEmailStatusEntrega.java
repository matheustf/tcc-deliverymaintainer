package com.puc.tcc.deliverymaintainer.config.email;

public enum ConteudoEmailStatusEntrega {

	EM_SEPARACAO("Seu produto acaba ser separado para Entrega"), 
	ENVIADO("Seu produto acaba ser enviado para os correios"), 
	EM_TRANSPORTE("Seu produto já foi separado pelos correios e agora está em destino à seu endereço"), 
	ENTREGUE("Ótimas notícias, seu produto foi entregue"), 
	PROBLEMAS_NA_ENTREGA("Tivemos um problema na usa entrega, mas já estamos resolvendo"), 
	CANCELADO("Sua entrega foi cancelada");

	private String descricao;

	private ConteudoEmailStatusEntrega() {
	}
	
	private ConteudoEmailStatusEntrega(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return this.descricao;
	}
}
