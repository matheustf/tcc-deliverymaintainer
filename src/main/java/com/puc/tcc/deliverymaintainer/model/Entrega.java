package com.puc.tcc.deliverymaintainer.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Entrega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2043008054923050692L;

	private String id;
	
	@NotNull
	private String codigoDaEntrega;
	
	private String codigoDeRastreio;

	@NotNull
	private String idCliente;
	
	@NotNull
	private String idFornecedor;
	
	@NotNull
	private String idCompra;
	
	@NotNull
	private String estimativaDeEntrega;
	
	@NotNull
	private StatusDaEntrega statusDaEntrega;
	
	@NotNull
	private List<HistoricoDeEntrega> historicoDeEntrega;
	
	public void addHistoricoDeEntrega(HistoricoDeEntrega historicoDeEntrega){
		this.historicoDeEntrega.add(historicoDeEntrega);
	}
	
	public Entrega update(Entrega entregaDoPedido, Entrega detailsEntregaDoPedido) {
		entregaDoPedido.setEstimativaDeEntrega(detailsEntregaDoPedido.getEstimativaDeEntrega());
		
		return entregaDoPedido;
	}
	
}